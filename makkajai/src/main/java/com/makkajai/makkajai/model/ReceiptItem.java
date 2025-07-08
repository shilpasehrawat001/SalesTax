package com.makkajai.makkajai.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiptItem {
    private static final Logger logger = LoggerFactory.getLogger(ReceiptItem.class);

    private final Item item;
    private final int quantity;

    public ReceiptItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        logger.info("ReceiptItem created: {} x{}", item.getName(), quantity);
    }

    public double getTotalTax() {
        double totalTax = item.calculateTax() * quantity;
        logger.info("Total tax for '{}': {}", item.getName(), totalTax);
        return totalTax;
    }

    public double getTotalPrice() {
        double totalPrice = item.getTotalPrice() * quantity;
        logger.info("Total price for '{}': {}", item.getName(), totalPrice);
        return totalPrice;
    }

    public String getPrintableLine() {
        String line = quantity + " " + item.getName() + ": " + String.format("%.2f", getTotalPrice());
        logger.info("Printable line: {}", line);
        return line;
    }
}