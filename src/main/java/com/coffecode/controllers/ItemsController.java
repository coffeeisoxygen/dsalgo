package com.coffecode.controllers;

import java.util.List;

import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.handlers.AnimationHandler;
import com.coffecode.models.ItemsModel;

public class ItemsController<T extends Comparable<T>> {

    private final ItemsModel<T> model;

    public ItemsController(ItemsModel<T> model) {
        this.model = model;
    }

    public ItemsModel<T> getModel() {
        return model;
    }

    public void addItem(T item) {
        model.addItem(item);
    }

    public void addRandomStrings(int length, int count) {
        model.addRandomStrings(length, count);
    }

    public void addRandomIntegers(int min, int max, int count) {
        model.addRandomIntegers(min, max, count);
    }

    public void addItemsFromUserInput(List<T> items) {
        model.addItemsFromUserInput(items);
    }

    public void resetItems() {
        model.resetItems();
    }

    public void setSortStrategy(SortAlgorithmType type) {
        model.setSortStrategy(type);
    }

    public void sortItems(AnimationHandler<T> animationHandler) {
        model.sortItems(animationHandler);
    }

    public boolean isSorted() {
        return model.isSorted();
    }

    public List<T> getItemList() {
        return model.getItemList();
    }

    public int getItemSize() {
        return model.getItemSize();
    }

    public SortAlgorithmType getCurrentSortAlgorithm() {
        return model.getCurrentSortAlgorithm();
    }
}