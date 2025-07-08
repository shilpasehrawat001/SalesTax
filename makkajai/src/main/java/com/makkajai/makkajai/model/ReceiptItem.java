package com.makkajai.makkajai.model;

import com.makkajai.makkajai.service.TaxCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiptItem {
    private static final Logger logger = LoggerFactory.getLogger(ReceiptItem.class);

    private final Item item;
    private final int quantity;
    private final double unitTax; // Caching tax at construction

    public ReceiptItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.unitTax = TaxCalculator.calculateTax(item); // Calculated only once
        logger.info("ReceiptItem created: {} x {}", item.getName(), quantity);
    }

    public double getTotalTax() {
        return unitTax * quantity;
    }

    public double getTotalPrice() {
        return (item.getPrice() + unitTax) * quantity;
    }

    public String getPrintableLine() {
        String line = quantity + " " + item.getName() + ": " + String.format("%.2f", getTotalPrice());
        logger.info("Printable line: {}", line);
        return line;
    }
}