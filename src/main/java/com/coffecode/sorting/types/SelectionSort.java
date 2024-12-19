package com.coffecode.sorting.types;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjIntConsumer;

import com.coffecode.sorting.SortStrategy;

public class SelectionSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(List<T> items, ObjIntConsumer<List<T>> updateUI) throws InterruptedException {
        int n = items.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (items.get(j).compareTo(items.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            T temp = items.get(minIndex);
            items.set(minIndex, items.get(i));
            items.set(i, temp);

            updateUI.accept(new ArrayList<>(items), i);
            Thread.sleep(100); // Delay for visualization
        }
        updateUI.accept(new ArrayList<>(items), -1);
    }
}
