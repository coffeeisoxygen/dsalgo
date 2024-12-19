package com.coffecode.sorting;

import java.util.List;

public interface SortStrategy<T extends Comparable<T>> {

    void sort(List<T> items) throws InterruptedException;
}
