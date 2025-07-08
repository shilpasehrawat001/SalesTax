package com.makkajai.makkajai.util;

import com.makkajai.makkajai.model.Item;

public class InputParser {
    public static Item parseLine(String line) {
        int quantity = Integer.parseInt(line.substring(0, line.indexOf(' ')).trim());
        String namePricePart = line.substring(line.indexOf(' ') + 1);
        String[] parts = namePricePart.split(" at ");
        String name = parts[0].trim();
        double price = Double.parseDouble(parts[1].trim());

        boolean isImported = name.contains("imported");
        boolean isExempt = name.matches(".*(book|chocolate|pill).*\\b");

        return new Item(name, price, isImported, isExempt);
    }
}