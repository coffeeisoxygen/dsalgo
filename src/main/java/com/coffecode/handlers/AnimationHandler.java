package com.coffecode.handlers;

import java.util.List;
import java.util.function.Consumer;

import javax.swing.SwingUtilities;

public class AnimationHandler<T extends Comparable<T>> implements IAnimate {

    private final int delay;
    private final Consumer<List<T>> updateUI;
    private boolean isPaused;
    private boolean isStopped;

    public AnimationHandler(int delay, Consumer<List<T>> updateUI) {
        this.delay = delay;
        this.updateUI = updateUI;
        this.isPaused = false;
        this.isStopped = false;
    }

    @Override
    public void start() {
        isPaused = false;
        isStopped = false;
    }

    @Override
    public void pause() {
        isPaused = true;
    }

    @Override
    public void resume() {
        isPaused = false;
        synchronized (this) {
            notify();
        }
    }

    @Override
    public void stop() {
        isStopped = true;
        synchronized (this) {
            notify();
        }
    }

    public void animate(List<T> data) {
        SwingUtilities.invokeLater(() -> updateUI.accept(data));
        try {
            synchronized (this) {
                while (isPaused) {
                    wait();
                }
                if (isStopped) {
                    return;
                }
            }
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}