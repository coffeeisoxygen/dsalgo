package com.coffecode.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class ResultPanel extends JPanel {

    public ResultPanel() {
        setLayout(new MigLayout("", "[grow]", "[grow]"));

        // Placeholder for result components
        JLabel placeholder = new JLabel("Result Area");
        add(placeholder, "span, align center");
    }
}