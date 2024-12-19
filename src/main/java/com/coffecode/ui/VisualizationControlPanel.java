package com.coffecode.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class VisualizationControlPanel extends JPanel {

    private JPanel controlPanel;
    private VisualizationPanel visualizationPanel;

    public VisualizationControlPanel() {
        setLayout(new BorderLayout());
        setBorder(new TitledBorder("Visualization and Control"));

        // Initialize panels
        controlPanel = new JPanel(new GridBagLayout());
        visualizationPanel = new VisualizationPanel();

        // Create control buttons
        JButton startButton = new JButton("Start");
        JButton pauseButton = new JButton("Pause");
        JButton stopButton = new JButton("Stop");
        JButton resetButton = new JButton("Reset");

        // Add buttons to control panel
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

        // Add panels to main panel
        add(controlPanel, BorderLayout.NORTH);
        add(visualizationPanel, BorderLayout.CENTER);
    }
}