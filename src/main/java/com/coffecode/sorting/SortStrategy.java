package com.coffecode.sorting;

import java.util.List;
import java.util.function.Consumer;

public interface SortStrategy<T extends Comparable<T>> {

    void sort(List<T> items, Consumer<List<T>> updateUI) throws InterruptedException;
}