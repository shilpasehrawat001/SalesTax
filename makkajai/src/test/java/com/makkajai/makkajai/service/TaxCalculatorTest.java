package com.makkajai.makkajai.service;

import com.makkajai.makkajai.model.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaxCalculatorTest {
    @Test
    public void testBasicSalesTaxOnly() {
        Item item = new Item("music CD", 14.99, false, false);
        assertEquals(1.50, TaxCalculator.calculateTax(item), 0.01);
    }

    @Test
    public void testImportedExemptItemTax() {
        Item item = new Item("imported chocolate", 10.00, true, true);
        assertEquals(0.50, TaxCalculator.calculateTax(item), 0.01);
    }

    @Test
    public void testNoTaxItem() {
        Item item = new Item("book", 12.49, false, true);
        assertEquals(0.0, TaxCalculator.calculateTax(item), 0.01);
    }
}
