package com.coffecode.sorting.types;

import java.util.List;

import com.coffecode.interfaces.SortStrategy;

public class QuickSort implements SortStrategy {

    @Override
    public void sort(List<String> items) {
        quickSort(items, 0, items.size() - 1);
    }

    private void quickSort(List<String> items, int low, int high) {
        if (low < high) {
            int pi = partition(items, low, high);
            quickSort(items, low, pi - 1);
            quickSort(items, pi + 1, high);
        }
    }

    private int partition(List<String> items, int low, int high) {
        String pivot = items.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (items.get(j).compareTo(pivot) < 0) {
                i++;
                String temp = items.get(i);
                items.set(i, items.get(j));
                items.set(j, temp);
            }
        }
        String temp = items.get(i + 1);
        items.set(i + 1, items.get(high));
        items.set(high, temp);
        return i + 1;
    }
}
