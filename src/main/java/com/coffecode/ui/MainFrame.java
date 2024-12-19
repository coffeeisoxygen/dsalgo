package com.coffecode.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.coffecode.context.AppContext;

public class MainFrame<T extends Comparable<T>> extends JFrame {

    private DataPreparationPanel<T> dataPreparationPanel;
    private AlgorithmSettingsPanel algorithmSettingsPanel;
    private VisualizationControlPanel<T> visualizationControlPanel;

    public MainFrame(AppContext<T> context) {
        super("Sorting App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Initialize panels with controller from context
        dataPreparationPanel = new DataPreparationPanel<>(context.getItemsController());
        algorithmSettingsPanel = new AlgorithmSettingsPanel();
        visualizationControlPanel = new VisualizationControlPanel<>(context);

        // Set static size for DataPreparationPanel
        dataPreparationPanel.setPreferredSize(new Dimension(200, getHeight()));

        // Create a panel to hold DataPreparationPanel and AlgorithmSettingsPanel side by side
        JPanel sidePanel = new JPanel(new GridLayout(1, 2));
        sidePanel.add(dataPreparationPanel);
        sidePanel.add(algorithmSettingsPanel);

        // Set up split pane between AlgorithmSettingsPanel and VisualizationControlPanel
        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidePanel, visualizationControlPanel);
        mainSplitPane.setResizeWeight(0.3);        mainSplitPane.setDividerLocation(400); // Set initial position for horizontal split pane        // Add panels to frame
        add(mainSplitPane, BorderLayout.CENTER);

        setVisible(true);
    }
}