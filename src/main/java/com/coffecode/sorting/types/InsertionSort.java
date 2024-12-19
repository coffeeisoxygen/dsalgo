package com.coffecode.sorting.types;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjIntConsumer;

import com.coffecode.sorting.SortStrategy;

public class InsertionSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(List<T> items, ObjIntConsumer<List<T>> updateUI) throws InterruptedException {
        int n = items.size();
        for (int i = 1; i < n; i++) {
            T key = items.get(i);
            int j = i - 1;

            while (j >= 0 && items.get(j).compareTo(key) > 0) {
                items.set(j + 1, items.get(j));
                j--;
                updateUI.accept(new ArrayList<>(items), j + 1);
                Thread.sleep(100); // Delay for visualization
            }
            items.set(j + 1, key);
            updateUI.accept(new ArrayList<>(items), j + 1);
            Thread.sleep(100); // Delay for visualization
        }
        updateUI.accept(new ArrayList<>(items), -1);
    }
}
