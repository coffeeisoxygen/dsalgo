package com.coffecode.sorting.factory;

import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.interfaces.SortStrategy;
import com.coffecode.sorting.types.BubbleSort;
import com.coffecode.sorting.types.MergeSort;
import com.coffecode.sorting.types.QuickSort;

public class SortFactory {

    public static SortStrategy getSortStrategy(SortAlgorithmType type) {
        switch (type) {
            case BUBBLESORT -> {
                return new BubbleSort();
            }
            case QUICKSORT -> {
                return new QuickSort();
            }
            case MERGESORT -> {
                return new MergeSort();
            }
            default -> throw new IllegalArgumentException("Invalid sort algorithm type");
        }
        // Tambahkan strategi pengurutan lainnya di sini
            }
}
