package com.coffecode.sorting.types;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjIntConsumer;

import com.coffecode.sorting.SortStrategy;

public class CountingSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(List<T> items, ObjIntConsumer<List<T>> updateUI) throws InterruptedException {
        // Convert items to integers (assuming they are of type Integer)
        List<Integer> integers = new ArrayList<>();
        for (T item : items) {
            integers.add((Integer) item);
        }

        int max = integers.stream().max(Integer::compare).orElse(0);
        int min = integers.stream().min(Integer::compare).orElse(0);
        int range = max - min + 1;

        int[] count = new int[range];
        List<Integer> output = new ArrayList<>(integers.size());

        for (int i = 0; i < integers.size(); i++) {
            count[integers.get(i) - min]++;
        }

        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                output.add(i + min);
                count[i]--;
            }
        }

        for (int i = 0; i < output.size(); i++) {
            integers.set(i, output.get(i));
        }

        // Convert back to original type
        for (int i = 0; i < integers.size(); i++) {
            items.set(i, (T) integers.get(i));
        }

        updateUI.accept(new ArrayList<>(items), -1);
        Thread.sleep(100); // Delay for visualization
    }
}
