package com.makkajai.makkajai.model;

import com.makkajai.makkajai.model.Item;
import com.makkajai.makkajai.model.Receipt;
import com.makkajai.makkajai.model.ReceiptItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {

    @Test
    public void testReceiptTotals() {
        Receipt receipt = new Receipt();
        receipt.addItem(new ReceiptItem(new Item("book", 12.49, false, true), 1));
        receipt.addItem(new ReceiptItem(new Item("music CD", 14.99, false, false), 1));
        receipt.addItem(new ReceiptItem(new Item("chocolate bar", 0.85, false, true), 1));

        assertEquals(1.50, receipt.getTotalSalesTax(), 0.01);
        assertEquals(29.83, receipt.getTotalAmount(), 0.01);
    }
}