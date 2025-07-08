package com.makkajai.makkajai.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private static final Logger logger = LoggerFactory.getLogger(Receipt.class);

    private final List<ReceiptItem> items = new ArrayList<>();

    public void addItem(ReceiptItem item) {
        items.add(item);
        logger.info("Item added to receipt: {}", item.getPrintableLine());
    }

    public double getTotalSalesTax() {
        double totalTax = items.stream().mapToDouble(ReceiptItem::getTotalTax).sum();
        logger.info("Total sales tax: {}", totalTax);
        return totalTax;
    }

    public double getTotalAmount() {
        double totalAmount = items.stream().mapToDouble(ReceiptItem::getTotalPrice).sum();
        logger.info("Total amount: {}", totalAmount);
        return totalAmount;
    }

    public void printReceipt() {
        logger.info("Printing receipt");
        for (ReceiptItem item : items) {
            System.out.println(item.getPrintableLine());
        }
        System.out.println("Sales Taxes: " + String.format("%.2f", getTotalSalesTax()));
        System.out.println("Total: " + String.format("%.2f", getTotalAmount()));
    }
}