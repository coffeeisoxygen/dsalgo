package com.coffecode.sorting.types;

import java.util.List;
import java.util.function.ObjIntConsumer;

import com.coffecode.sorting.SortStrategy;

public class BubbleSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(List<T> items, ObjIntConsumer<List<T>> updateUI) throws InterruptedException {
        int n = items.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (items.get(j).compareTo(items.get(j + 1)) > 0) {
                    // Swap items[j] and items[j+1]
                    T temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);

                    // Update visualization with pointer and swap positions
                    updateUI.accept(items, j);
                    Thread.sleep(100); // Delay for visualization
                }
            }
        }
        // Final update to remove pointer
        updateUI.accept(items, -1);
    }
}