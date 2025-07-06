package com.makkajai.makkajai.runner;

import com.makkajai.makkajai.model.Item;
import com.makkajai.makkajai.receipt.ReceiptItem;
import com.makkajai.makkajai.service.TaxCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private static final Logger logger = LoggerFactory.getLogger(Receipt.class);

    private final List<ReceiptItem> items = new ArrayList<>();
    private double totalTax = 0.0;
    private double totalPrice = 0.0;

    public void addItem(Item item, int quantity) {
        logger.info("Adding item to receipt: {} (Qty: {})", item.getName(), quantity);

        double taxPerUnit = TaxCalculator.calculateTax(item);
        double itemTax = taxPerUnit * quantity;
        double itemTotal = (item.getPrice() + taxPerUnit) * quantity;

        items.add(new ReceiptItem(item, quantity, itemTotal, itemTax));

        totalTax += itemTax;
        totalPrice += itemTotal;

        logger.debug("Item tax: {}, Item total price: {}", itemTax, itemTotal);
        logger.info("Running totals - Tax: {}, Price: {}", totalTax, totalPrice);
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
