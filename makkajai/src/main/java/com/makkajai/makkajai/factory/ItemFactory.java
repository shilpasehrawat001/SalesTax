package com.makkajai.makkajai.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.makkajai.makkajai.model.item.ExemptItem;
import com.makkajai.makkajai.model.item.Item;
import com.makkajai.makkajai.model.item.TaxableItem;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * ItemFactory.java
 *
 * Factory class responsible for dynamically creating Item instances
 * as either TaxableItem or ExemptItem based on configured keywords.
 *
 * Responsibilities:
 * - Loads tax-exempt keywords from a JSON file at runtime.
 * - Determines whether an item is imported or exempt based on its name.
 * - Returns the appropriate subclass (TaxableItem or ExemptItem).
 *
 * OOP Principles:
 * - Open/Closed Principle: Can add new item types by extending Item and updating factory.
 * - Single Responsibility: Only responsible for object creation logic.
 *
 * Resources:
 * - exempt_keywords.json in the resources folder (e.g., ["book", "chocolate", "pill"])
 */
public class ItemFactory {
    private static final Set<String> exemptKeywords = new HashSet<>();

    static {
        try (InputStream is = ItemFactory.class.getResourceAsStream("/exempt_keywords.json")) {
            ObjectMapper mapper = new ObjectMapper();
            exemptKeywords.addAll(mapper.readValue(is, new TypeReference<Set<String>>() {}));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load exempt keywords", e);
        }
    }

    public static Item createItem(String name, double price) {
        boolean isImported = name.toLowerCase().contains("imported");
        boolean isExempt = exemptKeywords.stream()
                .anyMatch(keyword -> name.toLowerCase().contains(keyword));
        return isExempt
                ? new ExemptItem(name, price, isImported)
                : new TaxableItem(name, price, isImported);
    }
}
