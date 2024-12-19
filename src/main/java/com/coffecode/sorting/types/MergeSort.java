package com.coffecode.sorting.types;

import java.util.ArrayList;
import java.util.List;

import com.coffecode.sorting.SortStrategy;

public class MergeSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(List<T> items) {
        mergeSort(items, 0, items.size() - 1);
    }

    private void mergeSort(List<T> items, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(items, left, mid);
            mergeSort(items, mid + 1, right);
            merge(items, left, mid, right);
        }
    }

    private void merge(List<T> items, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<T> leftArray = new ArrayList<>(n1);
        List<T> rightArray = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++) {
            leftArray.add(items.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightArray.add(items.get(mid + 1 + j));
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray.get(i).compareTo(rightArray.get(j)) <= 0) {
                items.set(k, leftArray.get(i));
                i++;
            } else {
                items.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            items.set(k, leftArray.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            items.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }
}
