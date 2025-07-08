package com.makkajai.makkajai.model;


import com.makkajai.makkajai.model.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    public void testBasicTaxableItem() {
        Item cd = new Item("music CD", 14.99, false, false);
        assertEquals(1.50, cd.calculateTax(), 0.01);
        assertEquals(16.49, cd.getTotalPrice(), 0.01);
    }

    @Test
    public void testImportedTaxExemptItem() {
        Item chocolate = new Item("imported chocolate", 10.00, true, true);
        assertEquals(0.50, chocolate.calculateTax(), 0.01);
        assertEquals(10.50, chocolate.getTotalPrice(), 0.01);
    }

    @Test
    public void testNonTaxableItem() {
        Item book = new Item("book", 12.49, false, true);
        assertEquals(0.00, book.calculateTax(), 0.01);
        assertEquals(12.49, book.getTotalPrice(), 0.01);
    }
}
