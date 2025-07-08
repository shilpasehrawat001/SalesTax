package com.makkajai.makkajai.util;


/**
 * InputParser.java
 *
 * Responsible for parsing a single line of input in the format:
 *     "<quantity> <item name> at <price>"
 *
 * For example:
 *     "1 imported box of chocolates at 10.00"
 *
 * Parsing Steps:
 * - Extracts the quantity (before the first space).
 * - Extracts the item name (between quantity and the last occurrence of " at ").
 * - Extracts the price (after " at ").
 *
 * Returns:
 * - A String array containing [quantity, item name, price as string]
 *
 * Throws:
 * - IllegalArgumentException with a helpful message if the input format is invalid.
 *
 * This class isolates parsing logic from domain or I/O logic for better separation of concerns.
 */



public class InputParser {
    public static String[] parseLine(String line) {
        try {
            int quantityEndIndex = line.indexOf(' ');
            if (quantityEndIndex == -1) throw new IllegalArgumentException("Missing quantity or item name");

            int atIndex = line.lastIndexOf(" at ");
            if (atIndex == -1) throw new IllegalArgumentException("Missing 'at' keyword or price");

            int quantity = Integer.parseInt(line.substring(0, quantityEndIndex).trim());
            String name = line.substring(quantityEndIndex + 1, atIndex).trim();
            double price = Double.parseDouble(line.substring(atIndex + 4).trim());

            return new String[] { String.valueOf(quantity), name, String.valueOf(price) };

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input format. Please use: '<quantity> <item name> at <price>'", e);
        }
    }
}
