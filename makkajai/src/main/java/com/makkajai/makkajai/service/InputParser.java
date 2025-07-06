package com.makkajai.makkajai.service;

import com.makkajai.makkajai.model.Item;
import com.makkajai.makkajai.runner.Receipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class InputParser {

    private static final Logger logger = LoggerFactory.getLogger(InputParser.class);

    private static final Set<String> EXEMPT_KEYWORDS = Set.of("book", "chocolate", "chocolates", "pill", "pills");

    public static void parseLine(String line, Receipt receipt) {
        try {
            logger.info("Parsing input line: {}", line);

            String[] parts = line.split(" at ");
            if (parts.length != 2) {
                logger.warn("Invalid format (missing 'at'): {}", line);
                System.out.println("Invalid input: " + line);
                return;
            }

            double price = Double.parseDouble(parts[1]);
            String leftPart = parts[0];
            int firstSpace = leftPart.indexOf(' ');
            int quantity = Integer.parseInt(leftPart.substring(0, firstSpace));
            String name = leftPart.substring(firstSpace + 1);

            boolean imported = name.contains("imported");
            boolean exempt = EXEMPT_KEYWORDS.stream().anyMatch(name::contains);

            logger.debug("Extracted - Quantity: {}, Name: '{}', Price: {}, Imported: {}, Exempt: {}",
                    quantity, name, price, imported, exempt);

            Item item = new Item(name, price, imported, exempt);
            receipt.addItem(item, quantity);
        } catch (Exception e) {
            logger.error("Failed to parse line: '{}'. Error: {}", line, e.getMessage());
            System.out.println("Invalid input: " + line);
        }
    }
}
