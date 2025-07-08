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
        double totalTax = 0.0;
        for (ReceiptItem item : items) {
            totalTax += item.getTotalTax();
        }
        logger.info("Total sales tax computed: {}", totalTax);
        return totalTax;
    }

    public double getTotalAmount() {
        double totalAmount = 0.0;
        for (ReceiptItem item : items) {
            totalAmount += item.getTotalPrice();
        }
        logger.info("Total amount computed: {}", totalAmount);
        return totalAmount;
    }

    public void printReceipt() {
        logger.info("----- Printing Receipt -----");
        for (ReceiptItem item : items) {
            System.out.println(item.getPrintableLine());
        }
        double totalTax = getTotalSalesTax();
        double total = getTotalAmount();
        String taxLine = "Sales Taxes: " + String.format("%.2f", totalTax);
        String totalLine = "Total: " + String.format("%.2f", total);
        logger.info(taxLine);
        logger.info(totalLine);
    }
}
