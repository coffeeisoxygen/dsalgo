package com.coffecode.ui;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

public class GridPanel<T extends Comparable<T>> extends JPanel {

    private VisualizationPanel<T> visualizationPanel;
    private PointerPanel pointerPanel;

    public GridPanel() {
        setLayout(new GridLayout(2, 1)); // 2 rows, 1 column
        visualizationPanel = new VisualizationPanel<>();
        pointerPanel = new PointerPanel();
        add(visualizationPanel);
        add(pointerPanel);
    }

    public void updateData(List<T> data, int pointer) {
        visualizationPanel.updateData(data);
        pointerPanel.updatePointer(pointer, data.size());
    }
}