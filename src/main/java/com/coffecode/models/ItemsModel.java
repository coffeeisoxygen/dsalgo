package com.coffecode.models;

import java.util.ArrayList;
import java.util.List;

import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.helper.RandomGenerator;
import com.coffecode.sorting.SortStrategy;
import com.coffecode.sorting.factory.SortFactory;

public class ItemsModel<T extends Comparable<T>> implements IItemsModel<T> {

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
    @Override
    public void addItem(T item) {
        if (validateItem(item)) {
            this.itemList.add(item);
            this.itemSize = this.itemList.size();
            this.isSorted = false; // Reset isSorted flag when a new item is added
        } else {
            throw new IllegalArgumentException("Invalid item: " + item);
        }
    }

    // Method to add multiple random strings to the list
    @Override
    public void addRandomStrings(int length, int count) {
        for (int i = 0; i < count; i++) {
            addItem((T) RandomGenerator.generateRandomString(length));
        }
    }

    // Method to add multiple random integers to the list
    @Override
    public void addRandomIntegers(int min, int max, int count) {
        for (int i = 0; i < count; i++) {
            addItem((T) Integer.valueOf(RandomGenerator.generateRandomNumber(min, max)));
        }
    }

    // Method to add multiple items from user input
    @Override
    public void addItemsFromUserInput(List<T> items) {
        for (T item : items) {
            addItem(item);
        }
    }

    // Method to reset the list
    @Override
    public void resetItems() {
        this.itemList.clear();
        this.itemSize = 0;
        this.isSorted = false; // Reset isSorted flag when items are reset
    }

    // Method to set the sorting strategy
    @Override
    public void setSortStrategy(SortAlgorithmType type) {
        this.sortStrategy = SortFactory.getSortStrategy(type);
        this.currentSortAlgorithm = type;
    }

    // Method to sort the list using the current strategy
    @Override
    public void sortItems() {
        if (this.sortStrategy != null) {
            this.sortStrategy.sort(this.itemList);
            this.isSorted = true; // Set isSorted flag to true after sorting
        }
    }

    // Method to check if the list is sorted
    @Override
    public boolean isSorted() {
        return this.isSorted;
    }

    // Getter for itemList
    @Override
    public List<T> getItemList() {
        return this.itemList;
    }

    // Getter for itemSize
    @Override
    public int getItemSize() {
        return this.itemSize;
    }

    // Getter for currentSortAlgorithm
    @Override
    public SortAlgorithmType getCurrentSortAlgorithm() {
        return this.currentSortAlgorithm;
    }

    // Validator for items
    private boolean validateItem(T item) {
        // Add validation logic here if needed
        return item != null;
    }
}
