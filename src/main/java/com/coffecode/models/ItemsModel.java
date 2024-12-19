package com.coffecode.models;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.handlers.AnimationHandler;
import com.coffecode.helper.RandomGenerator;
import com.coffecode.sorting.SortStrategy;
import com.coffecode.sorting.factory.SortFactory;

public class ItemsModel<T extends Comparable<T>> implements IItemsModel<T> {

    private static final Logger logger = LogManager.getLogger(ItemsModel.class);

    private final List<T> itemList;
    private int itemSize;
    private SortStrategy<T> sortStrategy;
    private boolean isSorted;
    private SortAlgorithmType currentSortAlgorithm;
    private final List<DataChangeListener<T>> listeners;

    public ItemsModel() {
        this.itemList = new ArrayList<>();
        this.listeners = new ArrayList<>();
        this.itemSize = 0;
        this.sortStrategy = null;
        this.isSorted = false;
        this.currentSortAlgorithm = null;
    }

    @SuppressWarnings("unchecked")
    private T castToT(Object obj) {
        return (T) obj;
    }

    // Method to add items to the list
    @Override
    public void addItem(T item) {
        if (validateItem(item)) {
            this.itemList.add(item);
            this.itemSize = this.itemList.size();
            this.isSorted = false; // Reset isSorted flag when a new item is added
            notifyListeners();
            logger.info("Item added: {}", item);
        } else {
            throw new IllegalArgumentException("Invalid item: " + item);
        }
    }

    private boolean validateItem(T item) {
        return item != null;
    }

    // Method to add multiple random strings to the list
    @Override
    public void addRandomStrings(int length, int count) {
        for (int i = 0; i < count; i++) {
            addItem(castToT(RandomGenerator.generateRandomString(length)));
        }
    }

    // Method to add multiple random integers to the list
    @Override
    public void addRandomIntegers(int min, int max, int count) {
        for (int i = 0; i < count; i++) {
            addItem(castToT(RandomGenerator.generateRandomNumber(min, max)));
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
        notifyListeners();
        logger.info("Items reset.");
    }

    // Method to set the sorting strategy
    @Override
    public void setSortStrategy(SortAlgorithmType type) {
        this.sortStrategy = SortFactory.getSortStrategy(type);
        this.currentSortAlgorithm = type;
        logger.info("Sort strategy set to: {}", type);
    }

    // Method to sort the list using the current strategy
    @Override
    public void sortItems(AnimationHandler<T> animationHandler) {
        if (this.sortStrategy != null) {
            try {
                logger.info("Starting sort with strategy: {}", this.currentSortAlgorithm);
                this.sortStrategy.sort(this.itemList, (data, pointer) -> animationHandler.animate(data, pointer));
                this.isSorted = true;
                notifyListeners();
                logger.info("Sorting completed.");
            } catch (InterruptedException e) {
                logger.error("Sorting interrupted.", e);
            }
        } else {
            logger.warn("Sort strategy is not set.");
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

    @Override
    public SortAlgorithmType getCurrentSortAlgorithm() {
        return this.currentSortAlgorithm;
    }

    public void addDataChangeListener(DataChangeListener<T> listener) {
        listeners.add(listener);
    }

    public void removeDataChangeListener(DataChangeListener<T> listener) {
        listeners.remove(listener);
    }

    public void notifyListeners() {
        for (DataChangeListener<T> listener : listeners) {
            listener.onDataChanged(itemList);
        }
    }
}