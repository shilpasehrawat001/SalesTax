package com.makkajai.makkajai.model.item;


import com.makkajai.makkajai.model.tax.TaxStrategy;

/**
 * Item.java (Abstract)
 *
 * Represents the base abstraction for any purchasable item.
 * Enforces a contract for all item types to define tax behavior and total pricing through polymorphism.
 *
 * Responsibilities:
 * - Encapsulates shared properties: name, price, and import status.
 * - Serves as a base for concrete item types like TaxableItem and ExemptItem.
 * - Delegates tax logic to strategy via composition:
 *      - calculateTax(): Uses assigned TaxStrategy to calculate tax.
 *      - getTotalPrice(): Returns total price including tax.
 *      - isExempt(): To be defined by concrete classes.
 *      - getBasicTaxRate(): To be defined by concrete classes.
 *
 * Design Benefits:
 * - Promotes the Open/Closed Principle (OCP): New tax rules or item categories can be added via new strategies or subclasses.
 * - Removes tax logic from data model, aligning with Single Responsibility Principle (SRP).
 * - Encourages extensibility and maintainability through polymorphism and delegation.
 *
 * Usage:
 * - Subclasses must implement the exemption and rate details (e.g., TaxableItem, ExemptItem).
 * - Used by ReceiptItem for pricing and tax summary.
 */
public abstract class Item {
    protected final String name;
    protected final double price;
    protected final boolean isImported;
    protected final TaxStrategy taxStrategy;

    public Item(String name, double price, boolean isImported, TaxStrategy taxStrategy) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.taxStrategy = taxStrategy;
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

    public double calculateTax() {
        return taxStrategy.calculateTax(price, isImported);
    }

    public double getTotalPrice() {
        return price + calculateTax();
    }

    public abstract boolean isExempt();

    public abstract double getBasicTaxRate();
}
