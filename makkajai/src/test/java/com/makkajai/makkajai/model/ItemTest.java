package com.makkajai.makkajai.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    @Test
    public void testItemProperties() {
        Item item = new Item("book", 12.49, false, true);
        assertEquals("book", item.getName());
        assertEquals(12.49, item.getPrice(), 0.01);
        assertTrue(item.isExempt());
        assertFalse(item.isImported());
    }
}
