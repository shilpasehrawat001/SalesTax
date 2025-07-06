package com.makkajai.makkajai.service;

import com.makkajai.makkajai.receipt.ReceiptItem;
import com.makkajai.makkajai.runner.Receipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiptPrinter {

    private static final Logger logger = LoggerFactory.getLogger(ReceiptPrinter.class);

    public static void printReceipt(Receipt receipt) {
        logger.info("Printing receipt...");

        for (ReceiptItem item : receipt.getItems()) {
            String output = String.format("%d %s: %.2f", item.getQuantity(), item.getName(), item.getTotalPrice());
            System.out.println(output);
            logger.debug("Printed item: {}", output);
        }

        String taxOutput = String.format("Sales Taxes: %.2f", receipt.getTotalTax());
        String totalOutput = String.format("Total: %.2f", receipt.getTotalPrice());

        logger.info(taxOutput);
        logger.info(totalOutput);
        logger.info("Receipt printed successfully.");
    }
}
