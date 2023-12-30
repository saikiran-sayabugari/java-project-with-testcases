package com.kiran;

import com.google.gson.Gson;
import com.kiran.controller.ItemController;
import com.kiran.repository.ItemRepository;
import spark.Spark;

public class WebServer {
    public static void main(String[] args) {
        // Create instances of dependencies
        ItemRepository itemRepository = new ItemRepository();
        Gson gson = new Gson();

        // Create ItemController with dependencies
        ItemController itemController = new ItemController(itemRepository, gson);

        // Set up Spark routes
        Spark.port(8080);

        // Define your routes using ItemController
        Spark.get("/items", itemController.getAllItems);
        Spark.get("/items/:id", itemController.getItemById);
        Spark.post("/items", itemController.addItem);
        Spark.put("/items/:id", itemController.updateItem);
        Spark.delete("/items/:id", itemController.deleteItem);
    }
}
