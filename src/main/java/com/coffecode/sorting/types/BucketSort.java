package com.coffecode.sorting.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.ObjIntConsumer;

import com.coffecode.sorting.SortStrategy;

public class BucketSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(List<T> items, ObjIntConsumer<List<T>> updateUI) throws InterruptedException {
        if (items.isEmpty()) {
            return;
        }

        // Convert items to doubles (assuming items are of type Double)
        List<Double> numbers = new ArrayList<>();
        for (T item : items) {
            numbers.add((Double) item);
        }

        // Find the maximum and minimum values
        double max = Collections.max(numbers);
        double min = Collections.min(numbers);
        int bucketCount = (int) Math.ceil(numbers.size() / 10.0);

        // Create empty buckets
        List<List<Double>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute the elements into buckets
        for (double num : numbers) {
            int bucketIndex = (int) ((num - min) / (max - min) * (bucketCount - 1));
            buckets.get(bucketIndex).add(num);
        }

        // Sort each bucket and concatenate the result
        numbers.clear();
        for (List<Double> bucket : buckets) {
            Collections.sort(bucket);
            numbers.addAll(bucket);
        }

        // Convert back to original type
        for (int i = 0; i < numbers.size(); i++) {
            items.set(i, (T) numbers.get(i));
        }

        updateUI.accept(new ArrayList<>(items), -1);
        Thread.sleep(100); // Delay for visualization
    }
}
