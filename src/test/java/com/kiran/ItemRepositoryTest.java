package com.kiran.repository;

import com.kiran.model.Item;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class ItemRepositoryTest {

    private ItemRepository itemRepository;

    @Before
    public void setUp() {
        itemRepository = new ItemRepository();
    }

    @Test
    public void testGetAllItems() {
        List<Item> items = itemRepository.getAllItems();
        assertNotNull(items);
        assertTrue(items.isEmpty());
    }

    @Test
    public void testGetItemById() {
        Item item = itemRepository.getItemById(1);
        assertNull(item);
    }

    @Test
    public void testAddItem() {
        Item newItem = new Item(1, "New Item", 50.0);
        Item addedItem = itemRepository.addItem(newItem);

        assertNotNull(addedItem);
        assertEquals(1, addedItem.getId());
        assertEquals("New Item", addedItem.getName());
        assertEquals(50.0, addedItem.getPrice(), 0.001);
    }

    @Test
    public void testUpdateItem() {
        Item newItem = new Item(1, "New Item", 50.0);
        itemRepository.addItem(newItem);

        Item updatedItem = new Item(1, "Updated Item", 75.0);
        Item result = itemRepository.updateItem(1, updatedItem);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Updated Item", result.getName());
        assertEquals(75.0, result.getPrice(), 0.001);
    }

    @Test
    public void testDeleteItem() {
        Item newItem = new Item(1, "New Item", 50.0);
        itemRepository.addItem(newItem);

        assertTrue(itemRepository.deleteItem(1));
        assertNull(itemRepository.getItemById(1));
    }
}

