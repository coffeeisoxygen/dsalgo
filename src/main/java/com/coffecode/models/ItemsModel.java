package com.coffecode.models;

import java.util.ArrayList;
import java.util.List;

import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.sorting.SortStrategy;
import com.coffecode.sorting.factory.SortFactory;

public class ItemsModel<T extends Comparable<T>> {

    private List<T> itemList;
    private int itemSize;
    private SortStrategy<T> sortStrategy;
    private boolean isSorted;
    private SortAlgorithmType currentSortAlgorithm;

    public ItemsModel() {
        this.itemList = new ArrayList<>();
        this.itemSize = 0;
        this.sortStrategy = null;
        this.isSorted = false;
        this.currentSortAlgorithm = null;
    }

    // Method to add items to the list
    public void addItem(T item) {
        if (validateItem(item)) {
            this.itemList.add(item);
            this.itemSize = this.itemList.size();
            this.isSorted = false; // Reset isSorted flag when a new item is added
        } else {
            throw new IllegalArgumentException("Invalid item: " + item);
        }
    }

    // Method to reset the list
    public void resetItems() {
        this.itemList.clear();
        this.itemSize = 0;
        this.isSorted = false; // Reset isSorted flag when items are reset
    }

    // Method to set the sorting strategy
    public void setSortStrategy(SortAlgorithmType type) {
        this.sortStrategy = SortFactory.getSortStrategy(type);
        this.currentSortAlgorithm = type;
    }

    // Method to sort the list using the current strategy
    public void sortItems() {
        if (this.sortStrategy != null) {
            this.sortStrategy.sort(this.itemList);
            this.isSorted = true; // Set isSorted flag to true after sorting
        }
    }

    // Method to check if the list is sorted
    public boolean isSorted() {
        return this.isSorted;
    }

    // Getter for itemList
    public List<T> getItemList() {
        return this.itemList;
    }

    // Getter for itemSize
    public int getItemSize() {
        return this.itemSize;
    }

    // Getter for currentSortAlgorithm
    public SortAlgorithmType getCurrentSortAlgorithm() {
        return this.currentSortAlgorithm;
    }

    // Validator for items
    private boolean validateItem(T item) {
        // Add validation logic here if needed
        return item != null;
    }
}
