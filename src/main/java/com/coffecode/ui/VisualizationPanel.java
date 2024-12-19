package com.coffecode.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class VisualizationPanel extends JPanel {

    private JPanel beforePanel;
    private JPanel afterPanel;

    public VisualizationPanel() {
        beforePanel = new JPanel(new MigLayout("", "[grow]", "[grow]"));
        afterPanel = new JPanel(new MigLayout("", "[grow]", "[grow]"));

        beforePanel.add(new JLabel("Before Sorting Visualization Area"), "align center");
        afterPanel.add(new JLabel("After Sorting Visualization Area"), "align center");
    }

    public JPanel getBeforePanel() {
        return beforePanel;
    }

    public JPanel getAfterPanel() {
        return afterPanel;
    }
}
