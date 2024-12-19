package com.coffecode.handlers;

import com.coffecode.controllers.ItemsController;

public class SortingHandler<T extends Comparable<T>> {

    private final ItemsController<T> controller;
    private final IAnimate animationHandler;

    public SortingHandler(ItemsController<T> controller, IAnimate animationHandler) {
        this.controller = controller;
        this.animationHandler = animationHandler;
    }

    public void startSorting() {
        new Thread(() -> {
            try {
                controller.getModel().sortItems((AnimationHandler<T>) animationHandler);
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