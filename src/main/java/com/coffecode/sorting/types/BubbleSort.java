package com.coffecode.sorting.types;

import java.util.List;

import com.coffecode.interfaces.SortStrategy;

public class BubbleSort implements SortStrategy {

    @Override
    public void sort(List<String> items) {
        int n = items.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (items.get(j).compareTo(items.get(j + 1)) > 0) {
                    // Swap items[j] and items[j+1]
                    String temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);
                }
            }
        }
    }
}
