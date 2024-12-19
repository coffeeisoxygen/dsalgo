package com.coffecode.models;

import java.util.List;

import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.handlers.AnimationHandler;

public interface IItemsModel<T extends Comparable<T>> {

    // Method to add items to the list
    void addItem(T item);

    // Method to add multiple random strings to the list
    void addRandomStrings(int length, int count);

    // Method to add multiple random integers to the list
    void addRandomIntegers(int min, int max, int count);

    // Method to add multiple items from user input
    void addItemsFromUserInput(List<T> items);

    // Method to reset the list
    void resetItems();

    // Method to set the sorting strategy
    void setSortStrategy(SortAlgorithmType type);

    // Method to sort the list using the current strategy
    void sortItems(AnimationHandler<T> animationHandler);

    // Method to check if the list is sorted
    boolean isSorted();

    // Getter for itemList
    List<T> getItemList();

    // Getter for itemSize
    int getItemSize();

    // Getter for currentSortAlgorithm
    SortAlgorithmType getCurrentSortAlgorithm();

}
