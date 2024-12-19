package com.coffecode.sorting.factory;

import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.sorting.SortStrategy;
import com.coffecode.sorting.types.BubbleSort;
import com.coffecode.sorting.types.InsertionSort;
import com.coffecode.sorting.types.MergeSort;
import com.coffecode.sorting.types.QuickSort;
import com.coffecode.sorting.types.SelectionSort;

public class SortFactory {

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
            default -> throw new IllegalArgumentException("Invalid sort algorithm type");
        }
    }
}
