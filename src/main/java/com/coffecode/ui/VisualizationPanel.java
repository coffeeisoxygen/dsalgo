package com.coffecode.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class VisualizationPanel<T extends Comparable<T>> extends JPanel {

    private transient List<T> data;

    public VisualizationPanel() {
        setPreferredSize(new Dimension(800, 400));
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

            if (data.get(0) instanceof Integer) {
                Integer maxValue = (Integer) data.stream().max(T::compareTo).orElse(null);

                for (int i = 0; i < data.size(); i++) {
                    Integer value = (Integer) data.get(i);
                    int barHeight = (int) ((double) value / maxValue * height);
                    g.setColor(Color.BLUE);
                    g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
                    g.setColor(Color.BLACK);
                    g.drawRect(i * barWidth, height - barHeight, barWidth, barHeight);
                }
            } else if (data.get(0) instanceof String) {
                int maxValue = data.stream().mapToInt(value -> ((String) value).length()).max().orElse(1);

                for (int i = 0; i < data.size(); i++) {
                    String value = (String) data.get(i);
                    int barHeight = (int) ((double) value.length() / maxValue * height);
                    g.setColor(Color.BLUE);
                    g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
                    g.setColor(Color.BLACK);
                    g.drawRect(i * barWidth, height - barHeight, barWidth, barHeight);
                }
            }
        }
    }
}