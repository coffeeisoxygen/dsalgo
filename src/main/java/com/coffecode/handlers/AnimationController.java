package com.coffecode.handlers;

import javax.swing.JButton;
import javax.swing.JSpinner;

public class AnimationController {

    private boolean isRunning;
    private boolean isPaused;
    private final JButton startPauseButton;
    private final JButton stopButton;
    private final JButton resetButton;
    private final JSpinner speedSpinner;

    public AnimationController(JButton startPauseButton, JButton stopButton, JButton resetButton,
            JSpinner speedSpinner) {
        this.startPauseButton = startPauseButton;
        this.stopButton = stopButton;
        this.resetButton = resetButton;
        this.speedSpinner = speedSpinner;
        this.isRunning = false;
        this.isPaused = false;
    }

    public void start() {
        isRunning = true;
        isPaused = false;
        startPauseButton.setText("Pause");
        startPauseButton.setBackground(java.awt.Color.YELLOW);
        stopButton.setEnabled(true);
        resetButton.setEnabled(false);
        speedSpinner.setEnabled(false);
    }

    public void pause() {
        isPaused = true;
        startPauseButton.setText("Resume");
        startPauseButton.setBackground(java.awt.Color.GREEN);
    }

    public void resume() {
        isPaused = false;
        startPauseButton.setText("Pause");
        startPauseButton.setBackground(java.awt.Color.YELLOW);
    }

    public void stop() {
        isRunning = false;
        isPaused = false;
        startPauseButton.setText("Start");
        startPauseButton.setBackground(java.awt.Color.GREEN);
        stopButton.setEnabled(false);
        resetButton.setEnabled(true);
        speedSpinner.setEnabled(true);
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isPaused() {
        return isPaused;
    }
}