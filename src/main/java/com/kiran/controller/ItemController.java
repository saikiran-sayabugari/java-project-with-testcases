package com.kiran.controller;

import com.google.gson.Gson;
import com.kiran.model.Item;
import com.kiran.repository.ItemRepository;
import spark.Route;

import java.util.List;

public class ItemController {

    private final ItemRepository itemRepository;
    private final Gson gson;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.gson = new Gson();
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
        Item newItem = gson.fromJson(request.body(), Item

