package com.coffecode.context;

import com.coffecode.controllers.ItemsController;
import com.coffecode.models.ItemsModel;

public class AppContext {

    private ItemsModel<String> itemsModel;
    private ItemsController<String> itemsController;

    public AppContext() {
        // Initialize model and controller
        itemsModel = new ItemsModel<>();
        itemsController = new ItemsController<>(itemsModel);
    }

    public ItemsModel<String> getItemsModel() {
        return itemsModel;
    }

    public ItemsController<String> getItemsController() {
        return itemsController;
    }
}
