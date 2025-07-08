package com.makkajai.makkajai.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReceiptTest {
    @Test
    public void testAddItemAndTotals() {
        Receipt receipt = new Receipt();
        receipt.addItem(new ReceiptItem(new Item("music CD", 14.99, false, false), 1));
        receipt.addItem(new ReceiptItem(new Item("book", 12.49, false, true), 1));

        assertTrue(receipt.getTotalAmount() > 0);
        assertTrue(receipt.getTotalSalesTax() > 0);
    }
}
