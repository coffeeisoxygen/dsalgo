package com.coffecode.models;

import java.util.ArrayList;
import java.util.List;

import com.coffecode.interfaces.SortStrategy;

public class ItemsModel {

    private List<String> itemList;
    private int itemSize;
    private SortStrategy sortStrategy;
    private boolean isSorted;

    public ItemsModel() {
        this.itemList = new ArrayList<>();
        this.itemSize = 0;
        this.sortStrategy = null;
        this.isSorted = false;
    }

    // Method to add items to the list
    public void addItem(String item) {
        this.itemList.add(item);
        this.itemSize = this.itemList.size();
        this.isSorted = false; // Reset isSorted flag when a new item is added
    }

    // Method to reset the list
    public void resetItems() {
        this.itemList.clear();
        this.itemSize = 0;
        this.isSorted = false; // Reset isSorted flag when items are reset
    }

    // Method to set the sorting strategy
    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
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
    public List<String> getItemList() {
        return this.itemList;
    }

    // Getter for itemSize
    public int getItemSize() {
        return this.itemSize;
    }
}
