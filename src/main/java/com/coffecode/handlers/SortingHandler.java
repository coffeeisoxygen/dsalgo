package com.coffecode.handlers;

import java.util.List;

import com.coffecode.controllers.ItemsController;
import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.sorting.SortStrategy;
import com.coffecode.sorting.factory.SortFactory;

public class SortingHandler<T extends Comparable<T>> {

    private final ItemsController<T> controller;

    public SortingHandler(ItemsController<T> controller) {
        this.controller = controller;
    }

    public void startSorting() {
        List<T> data = controller.getItemList();

        SortAlgorithmType sortAlgorithmType = controller.getCurrentSortAlgorithm();
        SortStrategy<T> sortStrategy = SortFactory.getSortStrategy(sortAlgorithmType);

        new Thread(() -> {
            try {
                sortStrategy.sort(data);
                controller.getModel().notifyListeners();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}