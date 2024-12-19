package com.coffecode.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import com.coffecode.context.AppContext;
import com.coffecode.controllers.ItemsController;
import com.coffecode.handlers.AnimationController;
import com.coffecode.handlers.AnimationHandler;
import com.coffecode.handlers.SortingHandler;

public class VisualizationControlPanel<T extends Comparable<T>> extends JPanel {

    private JPanel controlPanel;
    private VisualizationPanel<T> visualizationPanel;
    private SortingHandler<T> sortingHandler;
    private AnimationHandler<T> animationHandler;
    private AnimationController animationController;

    public VisualizationControlPanel(AppContext<T> context) {
        ItemsController<T> controller = context.getItemsController();
        setLayout(new BorderLayout());
        setBorder(new TitledBorder("Visualization and Control"));

        // Initialize panels
        controlPanel = new JPanel(new GridBagLayout());
        visualizationPanel = new VisualizationPanel<>();
        JSpinner speedSpinner = new JSpinner(new SpinnerNumberModel(100, 10, 1000, 10));

        // Register data change listener
        controller.getModel().addDataChangeListener((List<T> data) -> visualizationPanel.updateData(data));

        // Create control buttons with icons from FlatLaf
        JButton startPauseButton = new JButton("Start");
        startPauseButton.setBackground(java.awt.Color.GREEN);
        JButton stopButton = new JButton("Stop");
        stopButton.setBackground(java.awt.Color.RED);
        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(java.awt.Color.ORANGE);

        // Initialize AnimationController
        animationController = new AnimationController(startPauseButton, stopButton, resetButton, speedSpinner);

        // Add buttons and spinner to control panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        controlPanel.add(startPauseButton, gbc);
        gbc.gridx++;
        controlPanel.add(stopButton, gbc);
        gbc.gridx++;
        controlPanel.add(resetButton, gbc);
        gbc.gridx++;
        controlPanel.add(speedSpinner, gbc);

        // Add panels to main panel
        add(controlPanel, BorderLayout.NORTH);
        add(visualizationPanel, BorderLayout.CENTER);

        // Add action listener to start/pause button
        startPauseButton.addActionListener(e -> {
            if (!animationController.isRunning()) {
                if (controller.getItemSize() == 0) {
                    JOptionPane.showMessageDialog(this, "No items to sort. Please add items first.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (controller.getCurrentSortAlgorithm() == null) {
                    JOptionPane.showMessageDialog(this,
                            "Sort algorithm is not set. Please set the sort algorithm first.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int delay = (int) speedSpinner.getValue();
                animationHandler = new AnimationHandler<>(delay, data -> {
                    controller.getModel().notifyListeners();
                });
                sortingHandler = new SortingHandler<>(controller, animationHandler);
                sortingHandler.startSorting();
                animationController.start();
            } else if (animationController.isPaused()) {
                animationController.resume();
                sortingHandler.resumeSorting();
            } else {
                animationController.pause();
                sortingHandler.pauseSorting();
            }
        });

        // Add action listener to stop button
        stopButton.addActionListener(e -> {
            sortingHandler.stopSorting();
            animationController.stop();
        });

        // Add action listener to reset button
        resetButton.addActionListener(e -> {
            if (!animationController.isRunning()) {
                controller.resetItems();
            }
        });

        // Disable stop button initially
        stopButton.setEnabled(false);
    }

    public VisualizationPanel<T> getVisualizationPanel() {
        return visualizationPanel;
    }
}