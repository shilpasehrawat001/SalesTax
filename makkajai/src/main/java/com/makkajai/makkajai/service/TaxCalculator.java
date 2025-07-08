package com.makkajai.makkajai.service;

import com.makkajai.makkajai.model.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaxCalculator {
    private static final Logger logger = LoggerFactory.getLogger(TaxCalculator.class);

    private static final double BASIC_TAX_RATE = 0.10;
    private static final double IMPORT_DUTY_RATE = 0.05;

    public static double calculateTax(Item item) {
        double taxRate = 0.0;

        if (!item.isExempt()) {
            taxRate += BASIC_TAX_RATE;
        }

        if (item.isImported()) {
            taxRate += IMPORT_DUTY_RATE;
        }

        double rawTax = item.getPrice() * taxRate;
        double roundedTax = roundToNearestFiveCents(rawTax);

        logger.info("Calculating tax for item: {} | Raw: {}, Rounded: {}", item.getName(), rawTax, roundedTax);
        return roundedTax;
    }

    public static double roundToNearestFiveCents(double amount) {
        return Math.ceil(amount * 20.0) / 20.0;
    }
}
