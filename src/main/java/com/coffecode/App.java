package com.coffecode;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.models.ItemsModel;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        ItemsModel model = new ItemsModel();
        model.addItem("banana");
        model.addItem("apple");
        model.addItem("cherry");

        // Set sorting strategy to BubbleSort
        model.setSortStrategy(SortAlgorithmType.BUBBLESORT);
        model.sortItems();
        logSortedItems(model, "BubbleSort");

        // Reset items and add again
        model.resetItems();
        model.addItem("banana");
        model.addItem("apple");
        model.addItem("cherry");

        // Set sorting strategy to QuickSort
        model.setSortStrategy(SortAlgorithmType.QUICKSORT);
        model.sortItems();
        logSortedItems(model, "QuickSort");

        // Reset items and add again
        model.resetItems();
        model.addItem("banana");
        model.addItem("apple");
        model.addItem("cherry");

        // Set sorting strategy to MergeSort
        model.setSortStrategy(SortAlgorithmType.MERGESORT);
        model.sortItems();
        logSortedItems(model, "MergeSort");
    }

    private static void logSortedItems(ItemsModel model, String sortType) {
        List<String> sortedList = model.getItemList();
        logger.info("Sorted items using " + sortType + ": " + sortedList);
    }
}
