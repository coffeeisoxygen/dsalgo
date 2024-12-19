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
import com.coffecode.handlers.AnimationHandler;
import com.coffecode.handlers.SortingHandler;

public class VisualizationControlPanel<T extends Comparable<T>> extends JPanel {

    private JPanel controlPanel;
    private VisualizationPanel<T> visualizationPanel;
    private SortingHandler<T> sortingHandler;
    private AnimationHandler<T> animationHandler;

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
        JButton startButton = new JButton("Start");
        startButton.setBackground(java.awt.Color.GREEN);
        JButton pauseButton = new JButton("Pause");
        pauseButton.setBackground(java.awt.Color.YELLOW);
        JButton stopButton = new JButton("Stop");
        stopButton.setBackground(java.awt.Color.RED);
        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(java.awt.Color.ORANGE);
        JButton nextButton = new JButton("Next");
        nextButton.setBackground(java.awt.Color.CYAN);
        JButton prevButton = new JButton("Prev");
        prevButton.setBackground(java.awt.Color.CYAN);

        // Add buttons and spinner to control panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

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
        controlPanel.add(prevButton, gbc);
        gbc.gridx++;
        controlPanel.add(speedSpinner, gbc);

        // Add panels to main panel
        add(controlPanel, BorderLayout.NORTH);
        add(visualizationPanel, BorderLayout.CENTER);

        // Add action listener to start button
        startButton.addActionListener(e -> {
            if (controller.getItemSize() == 0) {
                JOptionPane.showMessageDialog(this, "No items to sort. Please add items first.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (controller.getCurrentSortAlgorithm() == null) {
                JOptionPane.showMessageDialog(this, "Sort algorithm is not set. Please set the sort algorithm first.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int delay = (int) speedSpinner.getValue();
            animationHandler = new AnimationHandler<>(delay, data -> {
                controller.getModel().notifyListeners();
            });
            sortingHandler = new SortingHandler<>(controller, animationHandler);
            sortingHandler.startSorting();
        });

        // Add action listener to reset button
        resetButton.addActionListener(e -> {
            controller.resetItems();
        });

        // Add action listener to pause button
        pauseButton.addActionListener(e -> {
            // Implement pause functionality
        });

        // Add action listener to stop button
        stopButton.addActionListener(e -> {
            // Implement stop functionality
        });

        // Add action listener to next button
        nextButton.addActionListener(e -> {
            // Implement next step functionality
        });

        // Add action listener to prev button
        prevButton.addActionListener(e -> {
            // Implement previous step functionality
        });
    }

    public VisualizationPanel<T> getVisualizationPanel() {
        return visualizationPanel;
    }
}