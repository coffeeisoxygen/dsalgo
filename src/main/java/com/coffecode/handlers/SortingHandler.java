package com.coffecode.handlers;

import com.coffecode.controllers.ItemsController;

public class SortingHandler<T extends Comparable<T>> {

    private final ItemsController<T> controller;
    private final AnimationHandler<T> animationHandler;

    public SortingHandler(ItemsController<T> controller, AnimationHandler<T> animationHandler) {
        this.controller = controller;
        this.animationHandler = animationHandler;
    }

    public void startSorting() {
        new Thread(() -> {
            try {
                controller.getModel().sortItems(animationHandler);
                animationHandler.complete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void pauseSorting() {
        animationHandler.pause();
    }

    public void resumeSorting() {
        animationHandler.resume();
    }

    public void stopSorting() {
        animationHandler.stop();
    }
}