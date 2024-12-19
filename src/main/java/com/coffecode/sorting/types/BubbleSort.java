package com.coffecode.sorting.types;

import java.util.List;
import java.util.function.Consumer;

import com.coffecode.sorting.SortStrategy;

public class BubbleSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(List<T> items, Consumer<List<T>> updateUI) throws InterruptedException {
        int n = items.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (items.get(j).compareTo(items.get(j + 1)) > 0) {
                    // Swap items[j] and items[j+1]
                    T temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);

                    // Update UI
                    updateUI.accept(items);
                }
            }
        }
    }
}