package com.coffecode.context;

import com.coffecode.controllers.ItemsController;
import com.coffecode.models.ItemsModel;

public class AppContext<T extends Comparable<T>> {

    private ItemsModel<T> itemsModel;
    private ItemsController<T> itemsController;

    public AppContext() {
        // Initialize model and controller
        itemsModel = new ItemsModel<>();
        itemsController = new ItemsController<>(itemsModel);
    }

    public ItemsModel<T> getItemsModel() {
        return itemsModel;
    }

    public ItemsController<T> getItemsController() {
        return itemsController;
    }
}