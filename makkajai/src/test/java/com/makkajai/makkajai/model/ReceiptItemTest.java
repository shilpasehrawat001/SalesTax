package com.makkajai.makkajai.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.makkajai.makkajai.service.TaxCalculator;

public class ReceiptItemTest {
    @Test
    public void testReceiptItemTotalTax() {
        Item item = new Item("music CD", 14.99, false, false);
        ReceiptItem receiptItem = new ReceiptItem(item, 1);
        assertEquals(TaxCalculator.calculateTax(item), receiptItem.getTotalTax(), 0.01);
    }

    @Test
    public void testReceiptItemTotalPrice() {
        Item item = new Item("imported chocolate", 10.00, true, true);
        ReceiptItem receiptItem = new ReceiptItem(item, 1);
        assertEquals(10.50, receiptItem.getTotalPrice(), 0.01);
    }
}
