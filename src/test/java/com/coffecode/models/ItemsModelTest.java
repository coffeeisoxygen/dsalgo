package com.coffecode.models;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.coffecode.enums.SortAlgorithmType;

public class ItemsModelTest {

    @Test
    public void testBubbleSort() {
        ItemsModel model = new ItemsModel();
        model.addItem("banana");
        model.addItem("apple");
        model.addItem("cherry");

        model.setSortStrategy(SortAlgorithmType.BUBBLESORT);
        model.sortItems();

        List<String> sortedList = model.getItemList();
        assertEquals(Arrays.asList("apple", "banana", "cherry"), sortedList);
        assertTrue(model.isSorted());
    }

    @Test
    public void testQuickSort() {
        ItemsModel model = new ItemsModel();
        model.addItem("banana");
        model.addItem("apple");
        model.addItem("cherry");

        model.setSortStrategy(SortAlgorithmType.QUICKSORT);
        model.sortItems();

        List<String> sortedList = model.getItemList();
        assertEquals(Arrays.asList("apple", "banana", "cherry"), sortedList);
        assertTrue(model.isSorted());
    }

    @Test
    public void testMergeSort() {
        ItemsModel model = new ItemsModel();
        model.addItem("banana");
        model.addItem("apple");
        model.addItem("cherry");

        model.setSortStrategy(SortAlgorithmType.MERGESORT);
        model.sortItems();

        List<String> sortedList = model.getItemList();
        assertEquals(Arrays.asList("apple", "banana", "cherry"), sortedList);
        assertTrue(model.isSorted());
    }
}