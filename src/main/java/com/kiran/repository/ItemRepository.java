package com.kiran.repository;

import com.kiran.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemRepository {

    private final Map<Integer, Item> items = new HashMap<>();
    private int nextId = 1;

    public List<Item> getAllItems() {
        return new ArrayList<>(items.values());
    }

    public Item getItemById(int id) {
        return items.get(id);
    }

    public Item addItem(Item item) {
        item.setId(nextId);
        items.put(nextId, item);
        nextId++;
        return item;
    }

    public Item updateItem(int id, Item updatedItem) {
        if (items.containsKey(id)) {
            updatedItem.setId(id);
            items.put(id, updatedItem);
            return updatedItem;
        } else {
            return null;
        }
    }

    public boolean deleteItem(int id) {
        return items.remove(id) != null;
    }
}

