package com.makkajai.makkajai.model.item;

import com.makkajai.makkajai.model.tax.ExemptTaxStrategy;

import static com.makkajai.makkajai.service.TaxCalculator.roundToNearestFiveCents;

/**
 * ExemptItem.java
 *
 * Represents an item that is exempt from basic sales tax but may still be subject to import duty.
 * Inherits from the abstract {@link Item} class and defines behavior specific to tax-exempt items.
 *
 * Responsibilities:
 * - Applies no basic sales tax (0%).
 * - Applies import duty (5%) if the item is imported.
 * - Calculates and rounds the applicable tax.
 * - Computes the total price including tax.
 *
 * Design Notes:
 * - Implements tax rules for tax-exempt categories such as books, food, and medical products.
 * - Supports the Open/Closed Principle by keeping exempt logic separate from taxable logic.
 *
 * Key Methods:
 * - {@code calculateTax()} returns only import duty if applicable, rounded to nearest 0.05.
 * - {@code getTotalPrice()} returns the final price including tax.
 * - {@code isExempt()} always returns {@code true}.
 * - {@code getBasicTaxRate()} returns {@code 0.0}.
 *
 * Usage:
 * - Instantiated via {@link com.makkajai.makkajai.factory.ItemFactory} when an item matches exempt keywords.
 * - Used in receipt calculations to correctly apply tax rules for exempt goods.
 */



public class ExemptItem extends Item {

    public ExemptItem(String name, double price, boolean isImported) {
        super(name, price, isImported, new ExemptTaxStrategy());
    }

    @Override
    public double calculateTax() {
        double tax = isImported ? 0.05 * price : 0.0;
        return roundToNearestFiveCents(tax);
    }

    @Override
    public double getTotalPrice() {
        return price + calculateTax();
    }

    @Override
    public boolean isExempt() {
        return true;
    }

    @Override
    public double getBasicTaxRate() {
        return 0.0;
    }
}
