package com.makkajai.makkajai.service;

import com.makkajai.makkajai.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaxCalculator {

    private static final Logger logger = LoggerFactory.getLogger(TaxCalculator.class);

    public static double calculateTax(Item item) {
        logger.info("Calculating tax for item: {}", item.getName());
        double taxRate = 0.0;

        if (!item.isExempt()) {
            taxRate += 0.10;
            logger.debug("Basic sales tax applied (10%)");
        }

        if (item.isImported()) {
            taxRate += 0.05;
            logger.debug("Import duty applied (5%)");
        }

        double rawTax = item.getPrice() * taxRate;
        double roundedTax = roundTax(rawTax);

        logger.info("Raw tax: {}, Rounded tax: {}", rawTax, roundedTax);
        return roundedTax;
    }

    private static double roundTax(double tax) {
        double rounded = Math.ceil(tax * 20.0) / 20.0;
        logger.debug("Tax before rounding: {}, after rounding: {}", tax, rounded);
        return rounded;
    }
}
