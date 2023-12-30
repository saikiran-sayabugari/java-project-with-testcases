package com.kiran.controller;

import com.google.gson.Gson;
import com.kiran.model.Item;
import com.kiran.repository.ItemRepository;
import spark.Route;

import java.util.List;

public class ItemController {

    private final ItemRepository itemRepository;
    private final Gson gson;

    public ItemController(ItemRepository itemRepository, Gson gson) {
        this.itemRepository = itemRepository;
        this.gson = gson;
    }

    public Route getAllItems = (request, response) -> {
        List<Item> items = itemRepository.getAllItems();
        return gson.toJson(items);
    };

    public Route getItemById = (request, response) -> {
        int itemId = Integer.parseInt(request.params(":id"));
        Item item = itemRepository.getItemById(itemId);
        if (item != null) {
            return gson.toJson(item);
        } else {
            response.status(404);
            return "Item not found";
        }
    };

    public Route addItem = (request, response) -> {
        Item newItem = gson.fromJson(request.body(), Item.class);
        Item addedItem = itemRepository.addItem(newItem);
        response.status(201);
        return gson.toJson(addedItem);
    };

    public Route updateItem = (request, response) -> {
        int itemId = Integer.parseInt(request.params(":id"));
        Item updatedItem = gson.fromJson(request.body(), Item.class);
        Item result = itemRepository.updateItem(itemId, updatedItem);
        if (result != null) {
            return gson.toJson(result);
        } else {
            response.status(404);
            return "Item not found";
        }
    };

    public Route deleteItem = (request, response) -> {
        int itemId = Integer.parseInt(request.params(":id"));
        if (itemRepository.deleteItem(itemId)) {
            response.status(204);
            return "";
        } else {
            response.status(404);
            return "Item not found";
        }
    };
}
