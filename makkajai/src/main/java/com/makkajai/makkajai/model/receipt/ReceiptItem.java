package com.makkajai.makkajai.model.receipt;

import com.makkajai.makkajai.model.item.Item;

/**
 * ReceiptItem.java
 *
 * Represents a purchasable line item in a receipt.
 * Wraps an Item with a specified quantity.
 *
 * Responsibilities:
 * - Delegates tax and total price calculation to the underlying Item.
 * - Produces a formatted string suitable for receipt printing.
 *
 * OOP Principles:
 * - Delegation: Delegates tax logic to polymorphic Item subclasses.
 * - SRP: Only responsible for quantity-based wrapping and formatting.
 */
public class ReceiptItem {
    private final Item item;
    private final int quantity;

    public ReceiptItem(Item item, int quantity) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");

        this.item = item;
        this.quantity = quantity;
    }

    public double getTotalTax() {
        return item.calculateTax() * quantity;
    }

    public double getTotalPrice() {
        return item.getTotalPrice() * quantity;
    }

    public String getPrintableLine() {
        return quantity + " " + item.getName() + ": " + String.format("%.2f", getTotalPrice());
    }

    // Optionally exposing item details if needed for testing/debugging
    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
