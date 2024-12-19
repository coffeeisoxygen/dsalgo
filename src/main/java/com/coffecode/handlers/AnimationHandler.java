package com.coffecode.handlers;

import java.util.List;
import java.util.function.ObjIntConsumer;

import javax.swing.SwingUtilities;

public class AnimationHandler<T extends Comparable<T>> implements IAnimate {

    private final int delay;
    private final ObjIntConsumer<List<T>> updateUI;
    private final Runnable onComplete;
    private boolean isPaused;
    private boolean isStopped;

    public AnimationHandler(int delay, ObjIntConsumer<List<T>> updateUI, Runnable onComplete) {
        this.delay = delay;
        this.updateUI = updateUI;
        this.onComplete = onComplete;
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
            notifyAll();
        }
    }

    @Override
    public void stop() {
        isStopped = true;
        synchronized (this) {
            notifyAll();
        }
    }

    public void animate(List<T> data, int pointer) {
        SwingUtilities.invokeLater(() -> updateUI.accept(data, pointer));
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

    public void complete() {
        SwingUtilities.invokeLater(onComplete);
    }
}