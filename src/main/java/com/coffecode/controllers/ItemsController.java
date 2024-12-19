package com.coffecode.controllers;

import java.util.List;

import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.models.IItemsModel;

public class ItemsController<T extends Comparable<T>> {

    private IItemsModel<T> model;

    public ItemsController(IItemsModel<T> model) {
        this.model = model;
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

    public void sortItems() {
        model.sortItems();
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