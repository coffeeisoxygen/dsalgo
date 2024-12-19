package com.coffecode.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class VisualizationPanel extends JPanel {

    public VisualizationPanel() {
        setLayout(new MigLayout("", "[grow][grow]", "[grow]"));

        // Placeholder for visualization components
        JLabel placeholder = new JLabel("Visualization Area");
        add(placeholder, "span, align center");
    }
}
