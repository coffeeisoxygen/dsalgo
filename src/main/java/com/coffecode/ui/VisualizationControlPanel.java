package com.coffecode.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.coffecode.context.AppContext;
import com.coffecode.controllers.ItemsController;
import com.coffecode.handlers.AnimationHandler;
import com.coffecode.handlers.SortingHandler;

public class VisualizationControlPanel<T extends Comparable<T>> extends JPanel {

    private JPanel controlPanel;
    private VisualizationPanel<T> visualizationPanel;
    private SortingHandler<T> sortingHandler;

    public VisualizationControlPanel(AppContext<T> context) {
        ItemsController<T> controller = context.getItemsController();
        setLayout(new BorderLayout());
        setBorder(new TitledBorder("Visualization and Control"));

        // Initialize panels
        controlPanel = new JPanel(new GridBagLayout());
        visualizationPanel = new VisualizationPanel<>();
        JSpinner speedSpinner = new JSpinner(new SpinnerNumberModel(100, 10, 1000, 10));

        // Register data change listener
        controller.getModel().addDataChangeListener((List<T> data) -> {
            visualizationPanel.updateData(data);
        });

        // Create control buttons with icons from FlatLaf
        JButton startButton = new JButton(UIManager.getIcon("FileView.fileIcon"));
        JButton pauseButton = new JButton(UIManager.getIcon("FileView.directoryIcon"));
        JButton stopButton = new JButton(UIManager.getIcon("FileView.computerIcon"));
        JButton resetButton = new JButton(UIManager.getIcon("FileView.hardDriveIcon"));
        JButton nextButton = new JButton(UIManager.getIcon("FileView.floppyDriveIcon"));
        JButton prevButton = new JButton(UIManager.getIcon("FileView.floppyDriveIcon"));

        // Add buttons and spinner to control panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        controlPanel.add(prevButton, gbc);
        gbc.gridx++;
        controlPanel.add(startButton, gbc);
        gbc.gridx++;
        controlPanel.add(pauseButton, gbc);
        gbc.gridx++;
        controlPanel.add(stopButton, gbc);
        gbc.gridx++;
        controlPanel.add(resetButton, gbc);
        gbc.gridx++;
        controlPanel.add(nextButton, gbc);
        gbc.gridx++;
        controlPanel.add(speedSpinner, gbc);

        // Add panels to main panel
        add(controlPanel, BorderLayout.NORTH);
        add(visualizationPanel, BorderLayout.CENTER);

        // Add action listener to start button
        startButton.addActionListener(e -> {
            AnimationHandler<T> animationHandler = new AnimationHandler<>((int) speedSpinner.getValue(), data -> {
                controller.getModel().notifyListeners();
            });
            sortingHandler = new SortingHandler<>(controller, animationHandler);
            sortingHandler.startSorting();
        });
    }

    public VisualizationPanel<T> getVisualizationPanel() {
        return visualizationPanel;
    }
}