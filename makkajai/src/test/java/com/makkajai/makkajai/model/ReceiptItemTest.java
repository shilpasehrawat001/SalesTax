package com.makkajai.makkajai.model;


import com.makkajai.makkajai.model.Item;
import com.makkajai.makkajai.model.ReceiptItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReceiptItemTest {

    @Test
    public void testSingleQuantity() {
        Item item = new Item("imported perfume", 47.50, true, false);
        ReceiptItem receiptItem = new ReceiptItem(item, 1);

        assertEquals(7.15, receiptItem.getTotalTax(), 0.01);
        assertEquals(54.65, receiptItem.getTotalPrice(), 0.01);
        assertEquals("1 imported perfume: 54.65", receiptItem.getPrintableLine());
    }

    @Test
    public void testMultipleQuantity() {
        Item item = new Item("music CD", 14.99, false, false);
        ReceiptItem receiptItem = new ReceiptItem(item, 2);

        assertEquals(3.00, receiptItem.getTotalTax(), 0.01);
        assertEquals(32.98, receiptItem.getTotalPrice(), 0.01);
        assertEquals("2 music CD: 32.98", receiptItem.getPrintableLine());
    }
}
