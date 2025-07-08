package com.makkajai.makkajai.util;


import com.makkajai.makkajai.model.Item;
import com.makkajai.makkajai.util.InputParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {

    @Test
    public void testParseLineReturnsBook() {
        Item item = InputParser.parseLine("1 book at 12.49");
        assertEquals("book", item.getName());
        assertEquals(12.49, item.getPrice(), 0.01);
        assertFalse(item.isImported());
        assertTrue(item.isExempt());
    }
}