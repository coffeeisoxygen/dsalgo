package com.coffecode.sorting.types;

import java.util.List;

import com.coffecode.interfaces.SortStrategy;

public class MergeSort implements SortStrategy {

    @Override
    public void sort(List<String> items) {
        mergeSort(items, 0, items.size() - 1);
    }

    private void mergeSort(List<String> items, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(items, left, mid);
            mergeSort(items, mid + 1, right);
            merge(items, left, mid, right);
        }
    }

    private void merge(List<String> items, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = items.get(left + i);
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = items.get(mid + 1 + j);
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                items.set(k, leftArray[i]);
                i++;
            } else {
                items.set(k, rightArray[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            items.set(k, leftArray[i]);
            i++;
            k++;
        }

        while (j < n2) {
            items.set(k, rightArray[j]);
            j++;
            k++;
        }
    }
}
