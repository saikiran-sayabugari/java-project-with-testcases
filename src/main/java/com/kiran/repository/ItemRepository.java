package com.kiran.repository;

import com.kiran.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private final List<Item> items;

    public ItemRepository() {
        this.items = new ArrayList<>();
    }

    public List<Item> getAllItems() {
        return items;
    }

    public Item getItemById(int id) {
        // Implement your logic to retrieve an item by ID
        return null;
    }

    public Item addItem(Item item) {
        // Implement your logic to add an item
        items.add(item);
        return item;
    }

    public Item updateItem(int id, Item updatedItem) {
        // Implement your logic to update an item
        return null;
    }

    public boolean deleteItem(int id) {
        // Implement your logic to delete an item
        return false;
    }
}
