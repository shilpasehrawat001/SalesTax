package com.makkajai.makkajai.util;

import com.makkajai.makkajai.model.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {
    @Test
    public void testParseLine() {
        Item item = InputParser.parseLine("1 imported bottle of perfume at 47.50");
        assertEquals("imported bottle of perfume", item.getName());
        assertEquals(47.50, item.getPrice(), 0.01);
        assertTrue(item.isImported());
        assertFalse(item.isExempt());
    }
}
