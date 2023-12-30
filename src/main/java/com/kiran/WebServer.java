package com.kiran;

import com.google.gson.Gson;
import com.kiran.controller.ItemController;
import com.kiran.repository.ItemRepository;
import spark.Route;
import spark.Spark;

public class WebServer {

    public static void main(String[] args) {
        // Set up Spark server
        Spark.port(8080);

        // Initialize data repository and controller
        ItemRepository itemRepository = new ItemRepository();
        ItemController itemController = new ItemController(itemRepository);

        // Set up RESTful endpoints
        Spark.get("/items", itemController.getAllItems);
        Spark.get("/items/:id", itemController.getItemById);
        Spark.post("/items", itemController.addItem);
        Spark.put("/items/:id", itemController.updateItem);
        Spark.delete("/items/:id", itemController.deleteItem);
    }
}

