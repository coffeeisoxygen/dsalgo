package com.coffecode.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class VisualizationPanel extends JPanel {

    private List<Integer> data;

    public VisualizationPanel() {
        setPreferredSize(new Dimension(800, 400));
    }

    public void setData(List<Integer> data) {
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
            int maxValue = data.stream().max(Integer::compareTo).orElse(1);

            for (int i = 0; i < data.size(); i++) {
                int value = data.get(i);
                int barHeight = (int) ((double) value / maxValue * height);
                g.setColor(Color.BLUE);
                g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
                g.setColor(Color.BLACK);
                g.drawRect(i * barWidth, height - barHeight, barWidth, barHeight);
            }
        }
    }
}