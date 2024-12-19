package com.coffecode.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

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

        // Add panels to frame
        add(controlPanel, BorderLayout.NORTH);
        add(visualizationPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

}
