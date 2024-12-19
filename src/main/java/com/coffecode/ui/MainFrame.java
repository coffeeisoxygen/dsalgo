package com.coffecode.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import com.coffecode.context.AppContext;

public class MainFrame extends JFrame {

    private DataPreparationPanel<String> dataPreparationPanel;
    private AlgorithmSettingsPanel algorithmSettingsPanel;
    private VisualizationControlPanel visualizationControlPanel;

    public MainFrame(AppContext context) {
        super("Sorting App");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Initialize panels with controller from context
        dataPreparationPanel = new DataPreparationPanel<>(context.getItemsController());
        algorithmSettingsPanel = new AlgorithmSettingsPanel();
        visualizationControlPanel = new VisualizationControlPanel();

        // Set up split panes
        JSplitPane leftSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dataPreparationPanel, algorithmSettingsPanel);
        leftSplitPane.setResizeWeight(0.5);

        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftSplitPane, visualizationControlPanel);
        mainSplitPane.setResizeWeight(0.3);

        // Add panels to frame
        add(mainSplitPane, BorderLayout.CENTER);

        setVisible(true);
    }
}