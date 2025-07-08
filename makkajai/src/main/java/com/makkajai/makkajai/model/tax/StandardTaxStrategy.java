package com.makkajai.makkajai.model.tax;

import static com.makkajai.makkajai.service.TaxCalculator.roundToNearestFiveCents;

public class StandardTaxStrategy implements TaxStrategy {
    @Override
    public double calculateTax(double price, boolean isImported) {
        double tax = 0.10 * price;
        if (isImported) tax += 0.05 * price;
        return roundToNearestFiveCents(tax);
    }
}