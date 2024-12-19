package com.coffecode.sorting.types;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjIntConsumer;

import com.coffecode.sorting.SortStrategy;

public class HeapSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(List<T> items, ObjIntConsumer<List<T>> updateUI) throws InterruptedException {
        int n = items.size();

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(items, n, i, updateUI);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            T temp = items.get(0);
            items.set(0, items.get(i));
            items.set(i, temp);

            // Update UI
            updateUI.accept(new ArrayList<>(items), i);
            Thread.sleep(100); // Delay for visualization

            // Call heapify on the reduced heap
            heapify(items, i, 0, updateUI);
        }

        // Final update to remove pointer
        updateUI.accept(new ArrayList<>(items), -1);
    }

    private void heapify(List<T> items, int n, int i, ObjIntConsumer<List<T>> updateUI) throws InterruptedException {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child index
        int right = 2 * i + 2; // right child index

        // If left child is larger than root
        if (left < n && items.get(left).compareTo(items.get(largest)) > 0) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && items.get(right).compareTo(items.get(largest)) > 0) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            T swap = items.get(i);
            items.set(i, items.get(largest));
            items.set(largest, swap);

            // Update UI
            updateUI.accept(new ArrayList<>(items), largest);
            Thread.sleep(100); // Delay for visualization

            // Recursively heapify the affected sub-tree
            heapify(items, n, largest, updateUI);
        }
    }
}
