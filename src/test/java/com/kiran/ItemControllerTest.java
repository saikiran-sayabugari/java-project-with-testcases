package com.kiran.controller;

import com.google.gson.Gson;
import com.kiran.model.Item;
import com.kiran.repository.ItemRepository;
import spark.Request;
import spark.Response;
import spark.Route;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ItemControllerTest {

    private ItemRepository itemRepository;
    private ItemController itemController;
    private Request request;
    private Response response;

    @Before
    public void setUp() {
        itemRepository = mock(ItemRepository.class);
        itemController = new ItemController(itemRepository);
        request = mock(Request.class);
        response = mock(Response.class);
    }

    @Test
    public void testGetAllItems() {
        when(itemRepository.getAllItems()).thenReturn(null);
        assertNotNull(itemController.getAllItems.handle(request, response));
    }

    @Test
    public void testGetItemById() {
        when(request.params(":id")).thenReturn("1");
        when(itemRepository.getItemById(1)).thenReturn(new Item(1, "Test Item", 25.0));
        assertNotNull(itemController.getItemById.handle(request, response));
    }

    @Test
    public void testAddItem() {
        when(request.body()).thenReturn(new Gson().toJson(new Item(1, "Test Item", 25.0)));
        assertNotNull(itemController.addItem.handle(request, response));
    }

    @Test
    public void testUpdateItem() {
        when(request.params(":id")).thenReturn("1");
        when(request.body()).thenReturn(new Gson().toJson(new Item(1, "Test Item", 25.0)));
        when(itemRepository.updateItem(1, new Item(1, "Test Item", 25.0))).thenReturn(new Item(1, "Test Item", 25.0));
        assertNotNull(itemController.updateItem.handle(request, response));
    }

    @Test
    public void testDeleteItem() {
        when(request.params(":id")).thenReturn("1");
        when(itemRepository.deleteItem(1)).thenReturn(true);
        assertNotNull(itemController.deleteItem.handle(request, response));
    }
}

