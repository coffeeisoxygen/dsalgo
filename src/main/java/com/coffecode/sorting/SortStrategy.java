package com.coffecode.sorting;

import java.util.List;
import java.util.function.ObjIntConsumer;

public interface SortStrategy<T extends Comparable<T>> {

    void sort(List<T> items, ObjIntConsumer<List<T>> updateUI) throws InterruptedException;
}