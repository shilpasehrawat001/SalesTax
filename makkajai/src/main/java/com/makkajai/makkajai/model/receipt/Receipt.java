package com.makkajai.makkajai.model.receipt;

import java.util.ArrayList;
import java.util.List;

/**
 * Receipt.java
 *
 * Represents a complete receipt that aggregates multiple receipt items.
 *
 * Responsibilities:
 * - Maintains a list of ReceiptItem objects.
 * - Computes total sales tax and total amount for all items.
 * - Provides printable receipt lines including itemized details and summary.
 *
 * Key Methods:
 * - addItem(): Adds a ReceiptItem to the receipt.
 * - getTotalSalesTax(): Calculates total tax across all items.
 * - getTotalAmount(): Calculates the total price (with tax) for all items.
 * - getPrintableLines(): Returns a list of formatted strings for receipt output.
 *
 * Usage:
 * - Used in conjunction with ReceiptPrinter to display the final purchase summary.
 */

public class Receipt {
    private final List<ReceiptItem> items = new ArrayList<>();

    public void addItem(ReceiptItem item) {
        items.add(item);
    }

    public double getTotalSalesTax() {
        return items.stream().mapToDouble(ReceiptItem::getTotalTax).sum();
    }

    public double getTotalAmount() {
        return items.stream().mapToDouble(ReceiptItem::getTotalPrice).sum();
    }

    public List<String> getPrintableLines() {
        List<String> lines = new ArrayList<>();
        for (ReceiptItem item : items) {
            lines.add(item.getPrintableLine());
        }
        lines.add("Sales Taxes: " + String.format("%.2f", getTotalSalesTax()));
        lines.add("Total: " + String.format("%.2f", getTotalAmount()));
        return lines;
    }
}
