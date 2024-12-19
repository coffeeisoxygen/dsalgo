package com.coffecode.sorting.types;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.coffecode.sorting.SortStrategy;

public class QuickSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(List<T> items, Consumer<List<T>> updateUI) throws InterruptedException {
        quickSort(items, 0, items.size() - 1, updateUI);
    }

    private void quickSort(List<T> items, int low, int high, Consumer<List<T>> updateUI) throws InterruptedException {
        if (low < high) {
            int pi = partition(items, low, high, updateUI);
            quickSort(items, low, pi - 1, updateUI);
            quickSort(items, pi + 1, high, updateUI);
        }
    }

    private int partition(List<T> items, int low, int high, Consumer<List<T>> updateUI) {
        T pivot = items.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (items.get(j).compareTo(pivot) < 0) {
                i++;
                T temp = items.get(i);
                items.set(i, items.get(j));
                items.set(j, temp);
                updateUI.accept(new ArrayList<>(items));
            }
        }
        T temp = items.get(i + 1);
        items.set(i + 1, items.get(high));
        items.set(high, temp);
        updateUI.accept(new ArrayList<>(items));
        return i + 1;
    }
}
