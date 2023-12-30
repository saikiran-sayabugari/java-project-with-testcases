package com.kiran.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void testItem() {
        Item item = new Item(1, "TestItem", 25.0);
        assertEquals(1, item.getId());
        assertEquals("TestItem", item.getName());
        assertEquals(25.0, item.getPrice(), 0.001);
    }
}

