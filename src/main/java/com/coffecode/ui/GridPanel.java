package com.coffecode.ui;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

public class GridPanel<T extends Comparable<T>> extends JPanel {

    private VisualizationPanel<T> visualizationPanel;

    public GridPanel() {
        setLayout(new GridLayout(1, 1)); // 1 row, 1 column
        visualizationPanel = new VisualizationPanel<>();
        add(visualizationPanel);
    }

    public void updateData(List<T> data, int pointer, int swapIndex1, int swapIndex2) {
        visualizationPanel.updateData(data, pointer, swapIndex1, swapIndex2);
    }
}