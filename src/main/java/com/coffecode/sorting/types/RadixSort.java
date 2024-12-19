// package com.coffecode.sorting.types;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.function.ObjIntConsumer;

// import com.coffecode.sorting.SortStrategy;

// /**
// * This class is currently unused and paused for development.
// */
// @Deprecated
// public class RadixSort<T extends Comparable<T>> implements SortStrategy<T> {

// @Override
// public void sort(List<T> items, ObjIntConsumer<List<T>> updateUI) throws
// InterruptedException {
// // Convert items to integers (assuming they are of type Integer)
// List<Integer> integers = new ArrayList<>();
// for (T item : items) {
// if (item instanceof Integer integer) {
// integers.add(integer);
// } else {
// throw new IllegalArgumentException("RadixSort only supports Integer type");
// }
// }

// int max = integers.stream().max(Integer::compare).orElse(0);
// for (int exp = 1; max / exp > 0; exp *= 10) {
// countSort(integers, exp, updateUI);
// }

// // Convert back to original type
// for (int i = 0; i < integers.size(); i++) {
// items.set(i, (T) integers.get(i));
// }
// updateUI.accept(new ArrayList<>(items), -1);
// }

// private void countSort(List<Integer> items, int exp,
// ObjIntConsumer<List<Integer>> updateUI)
// throws InterruptedException {
// int n = items.size();
// int[] output = new int[n];
// int[] count = new int[10];

// // Count occurrences
// for (int i = 0; i < n; i++) {
// count[(items.get(i) / exp) % 10]++;
// }

// // Change count[i] to the actual position of this digit in output[]
// for (int i = 1; i < 10; i++) {
// count[i] += count[i - 1];
// }

// // Build the output array
// for (int i = n - 1; i >= 0; i--) {
// output[count[(items.get(i) / exp) % 10] - 1] = items.get(i);
// count[(items.get(i) / exp) % 10]--;
// }

// // Copy the output array to items[], so that items[] contains sorted numbers
// for (int i = 0; i < n; i++) {
// items.set(i, output[i]);
// updateUI.accept(new ArrayList<>(items), i);
// Thread.sleep(100); // Delay for visualization
// }
// }
// }