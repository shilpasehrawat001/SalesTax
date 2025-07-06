package com.makkajai.makkajai.receipt;

import com.makkajai.makkajai.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiptItem {

    private static final Logger logger = LoggerFactory.getLogger(ReceiptItem.class);

    private final Item item;
    private final int quantity;
    private final double totalPrice;
    private final double tax;

    public ReceiptItem(Item item, int quantity, double totalPrice, double tax) {
        this.item = item;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.tax = tax;

        logger.info("Created ReceiptItem - Quantity: {}, Name: {}, Tax: {}, Total Price: {}",
                quantity, item.getName(), tax, totalPrice);
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return item.getName();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTax() {
        return tax;
    }
}
