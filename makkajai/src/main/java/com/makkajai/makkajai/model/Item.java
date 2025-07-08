package com.makkajai.makkajai.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Item {
    private static final Logger logger = LoggerFactory.getLogger(Item.class);

    private final String name;
    private final double price;
    private final boolean isImported;
    private final boolean isExempt;

    public Item(String name, double price, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
        logger.info("Item created: {}, price: {}, imported: {}, exempt: {}", name, price, isImported, isExempt);
    }

    public double calculateTax() {
        logger.info("Calculating tax for item: {}", name);
        double taxRate = 0.0;
        if (!isExempt) {
            taxRate += 0.10;
        }
        if (isImported) {
            taxRate += 0.05;
        }
        double rawTax = price * taxRate;
        double roundedTax = roundTax(rawTax);
        logger.info("Raw tax: {}, Rounded tax: {}", rawTax, roundedTax);
        return roundedTax;
    }

    public double getTotalPrice() {
        double total = price + calculateTax();
        logger.info("Total price (with tax) for item '{}': {}", name, total);
        return total;
    }

    private double roundTax(double tax) {
        return Math.ceil(tax * 20.0) / 20.0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempt() {
        return isExempt;
    }
}
