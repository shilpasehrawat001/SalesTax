package com.makkajai.makkajai.model.tax;

import static com.makkajai.makkajai.service.TaxCalculator.roundToNearestFiveCents;

public class ExemptTaxStrategy implements TaxStrategy {
    @Override
    public double calculateTax(double price, boolean isImported) {
        double tax = isImported ? 0.05 * price : 0.0;
        return roundToNearestFiveCents(tax);
    }
}