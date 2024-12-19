package com.coffecode.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class MainFrame extends JFrame {

    private ControlPanel controlPanel;
    private VisualizationPanel visualizationPanel;
    private ResultPanel resultPanel;

    public MainFrame() {
        super("Sorting App");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Initialize panels
        controlPanel = new ControlPanel();
        visualizationPanel = new VisualizationPanel();
        resultPanel = new ResultPanel();

        // Set up split panes
        JSplitPane visualizationSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, visualizationPanel.getBeforePanel(), visualizationPanel.getAfterPanel());
        visualizationSplitPane.setResizeWeight(0.5);

        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, controlPanel, visualizationSplitPane);
        mainSplitPane.setResizeWeight(0.2);

        // Add panels to frame
        add(mainSplitPane, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
