package com.coffecode.sorting.types;

import java.util.List;

import com.coffecode.sorting.SortStrategy;

public class QuickSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(List<T> items) {
        quickSort(items, 0, items.size() - 1);
    }

    private void quickSort(List<T> items, int low, int high) {
        if (low < high) {
            int pi = partition(items, low, high);
            quickSort(items, low, pi - 1);
            quickSort(items, pi + 1, high);
        }
    }

    private int partition(List<T> items, int low, int high) {
        T pivot = items.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (items.get(j).compareTo(pivot) < 0) {
                i++;
                T temp = items.get(i);
                items.set(i, items.get(j));
                items.set(j, temp);
            }
        }
        T temp = items.get(i + 1);
        items.set(i + 1, items.get(high));
        items.set(high, temp);
        return i + 1;
    }
}
