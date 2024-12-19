package com.coffecode.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PointerPanel extends JPanel {

    private int pointer = -1;
    private int dataSize = 0;

    public PointerPanel() {
        setPreferredSize(new Dimension(800, 50));
    }

    public void updatePointer(int pointer, int dataSize) {
        this.pointer = pointer;
        this.dataSize = dataSize;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (dataSize > 0) {
            int width = getWidth();
            int barWidth = width / dataSize;

            for (int i = 0; i < dataSize; i++) {
                g.setColor(i == pointer ? Color.RED : Color.WHITE);
                g.fillRect(i * barWidth, 0, barWidth, getHeight());
                g.setColor(Color.BLACK);
                g.drawRect(i * barWidth, 0, barWidth, getHeight());
            }
        }
    }
}