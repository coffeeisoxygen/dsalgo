package com.coffecode.handlers;

import java.util.List;
import java.util.function.Consumer;

import javax.swing.SwingUtilities;

public class AnimationHandler<T extends Comparable<T>> {

    private final int delay;
    private final Consumer<List<T>> updateUI;

    public AnimationHandler(int delay, Consumer<List<T>> updateUI) {
        this.delay = delay;
        this.updateUI = updateUI;
    }

    public void animate(List<T> data) {
        SwingUtilities.invokeLater(() -> updateUI.accept(data));
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}