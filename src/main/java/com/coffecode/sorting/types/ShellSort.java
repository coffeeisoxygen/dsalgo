package com.coffecode.sorting.types;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjIntConsumer;

import com.coffecode.sorting.SortStrategy;

public class ShellSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(List<T> items, ObjIntConsumer<List<T>> updateUI) throws InterruptedException {
        int n = items.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = items.get(i);
                int j = i;
                while (j >= gap && items.get(j - gap).compareTo(temp) > 0) {
                    items.set(j, items.get(j - gap));
                    j -= gap;
                }
                items.set(j, temp);
            }
            updateUI.accept(new ArrayList<>(items), -1);
            Thread.sleep(100); // Delay for visualization
        }
    }
}
