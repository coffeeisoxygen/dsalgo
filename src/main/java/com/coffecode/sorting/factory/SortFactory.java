package com.coffecode.sorting.factory;

import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.sorting.SortStrategy;
import com.coffecode.sorting.types.BubbleSort;
import com.coffecode.sorting.types.BucketSort;
import com.coffecode.sorting.types.CountingSort;
import com.coffecode.sorting.types.HeapSort;
import com.coffecode.sorting.types.InsertionSort;
import com.coffecode.sorting.types.MergeSort;
import com.coffecode.sorting.types.QuickSort;
import com.coffecode.sorting.types.SelectionSort;
import com.coffecode.sorting.types.ShellSort;

public class SortFactory {

    // Private constructor to hide the implicit public one
    private SortFactory() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static <T extends Comparable<T>> SortStrategy<T> getSortStrategy(SortAlgorithmType type) {
        switch (type) {
            case BUBBLESORT -> {
                return new BubbleSort<>();
            }
            case QUICKSORT -> {
                return new QuickSort<>();
            }
            case MERGESORT -> {
                return new MergeSort<>();
            }
            case INSERTIONSORT -> {
                return new InsertionSort<>();
            }
            case SELECTIONSORT -> {
                return new SelectionSort<>();
            }
            case HEAPSORT -> {
                return new HeapSort<>();
            }
            case SHELLSORT -> {
                return new ShellSort<>();
            }
            case COUNTINGSORT -> {
                return new CountingSort<>();
            }
            case BUCKETSORT -> {
                return new BucketSort<>();
            }
            case RADIXSORT -> throw new UnsupportedOperationException("RadixSort is currently paused for development");
            default -> throw new IllegalArgumentException("Invalid sort algorithm type");
        }
    }
}
