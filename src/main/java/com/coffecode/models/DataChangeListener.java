package com.coffecode.models;

import java.util.List;

public interface DataChangeListener<T> {
    void onDataChanged(List<T> data);
}