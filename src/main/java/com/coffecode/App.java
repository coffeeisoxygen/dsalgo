package com.coffecode;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.models.ItemsModel;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        // Input type of items
        try (Scanner scanner = new Scanner(System.in)) {
            // Input type of items
            System.out.println("Enter type of items (int or string):");
            String itemType = scanner.nextLine().toLowerCase();
            
            if (itemType.equals("int")) {
                ItemsModel<Integer> model = new ItemsModel<>();
                System.out.println("Enter items (integers) separated by space:");
                String[] items = scanner.nextLine().split(" ");
                for (String item : items) {
                    model.addItem(Integer.parseInt(item));
                }
                processSorting(model, scanner);
            } else if (itemType.equals("string")) {
                ItemsModel<String> model = new ItemsModel<>();
                System.out.println("Enter items (strings) separated by space:");
                String[] items = scanner.nextLine().split(" ");
                for (String item : items) {
                    model.addItem(item);
                }
                processSorting(model, scanner);
            } else {
                System.out.println("Invalid item type.");
            }
        }
    }

    private static <T extends Comparable<T>> void processSorting(ItemsModel<T> model, Scanner scanner) {
        System.out.println("Enter sorting strategy (BUBBLESORT, QUICKSORT, MERGESORT):");
        String strategy = scanner.nextLine();
        SortAlgorithmType sortAlgorithmType = SortAlgorithmType.valueOf(strategy.toUpperCase());

        // Set sorting strategy and sort items
        model.setSortStrategy(sortAlgorithmType);
        model.sortItems();
        logSortedItems(model);
    }

    private static <T extends Comparable<T>> void logSortedItems(ItemsModel<T> model) {
        List<T> sortedList = model.getItemList();
        SortAlgorithmType sortType = model.getCurrentSortAlgorithm();
        logger.info("Sorted items using " + sortType + ": " + sortedList);
    }
}
