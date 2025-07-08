
package com.makkajai.makkajai.model.item;

import com.makkajai.makkajai.model.tax.StandardTaxStrategy;

import static com.makkajai.makkajai.service.TaxCalculator.roundToNearestFiveCents;


/**
 * TaxableItem.java
 *
 * Represents an item that is subject to basic sales tax and optionally import duty.
 * Extends the abstract {@link Item} class and implements tax-specific behavior.
 *
 * Responsibilities:
 * - Applies a basic sales tax rate of 10%.
 * - Applies an additional import duty of 5% if the item is imported.
 * - Rounds total tax using {@code roundToNearestFiveCents()} utility.
 * - Calculates final total price including tax.
 *
 * Design Notes:
 * - This class embodies the "Taxable" variant in the item hierarchy.
 * - Follows the Open/Closed Principle by isolating tax rules for taxable items.
 * - Complies with the Single Responsibility Principle by keeping tax logic specific to this class.
 *
 * Key Methods:
 * - {@code isExempt()} returns {@code false} for all taxable items.
 * - {@code getBasicTaxRate()} returns 0.10.
 * - {@code calculateTax()} computes and rounds combined tax.
 * - {@code getTotalPrice()} returns item price plus calculated tax.
 *
 * Usage:
 * - Instantiated via {@link com.makkajai.makkajai.factory.ItemFactory}.
 * - Used in receipts to compute tax and final amounts for taxable goods.
 */

public class TaxableItem extends Item {
    public TaxableItem(String name, double price, boolean isImported) {
        super(name, price, isImported, new StandardTaxStrategy());
    }

    @Override
    public boolean isExempt() {
        return false;
    }

    @Override
    public double getBasicTaxRate() {
        return 0.10;
    }

    @Override
    public double calculateTax() {
        double tax = 0.10 * price; // Basic sales tax
        if (isImported) {
            tax += 0.05 * price; // Import duty
        }
        return roundToNearestFiveCents(tax);
    }

    @Override
    public double getTotalPrice() {
        return price + calculateTax();
    }
}
