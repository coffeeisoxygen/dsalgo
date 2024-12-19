package com.coffecode.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class VisualizationPanel<T extends Comparable<T>> extends JPanel {

    private List<T> data;

    public VisualizationPanel() {
        setPreferredSize(new Dimension(800, 350));
    }

    public void setData(List<T> data) {
        this.data = data;
        repaint();
    }

    public void updateData(List<T> data) {
        this.data = data;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (data != null && !data.isEmpty()) {
            int width = getWidth();
            int height = getHeight();
            int barWidth = width / data.size();
            int maxValue = data.stream().mapToInt(value -> ((Integer) value)).max().orElse(1);

            for (int i = 0; i < data.size(); i++) {
                int value = (Integer) data.get(i);
                int barHeight = (int) ((double) value / maxValue * height);
                g.setColor(Color.BLUE);
                g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
                g.setColor(Color.BLACK);
                g.drawRect(i * barWidth, height - barHeight, barWidth, barHeight);
                g.drawString(String.valueOf(value), i * barWidth + barWidth / 2, height - barHeight - 5); // Draw value
            }
        }
    }
}