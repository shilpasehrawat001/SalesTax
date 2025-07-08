package com.makkajai.makkajai.util;

import com.makkajai.makkajai.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputParser {
    private static final Logger logger = LoggerFactory.getLogger(InputParser.class);

    public static Item parseLine(String line) {
        logger.info("Parsing input line: {}", line);
        // Placeholder logic, real parsing should go here
        return new Item("book", 12.49, false, true);
    }
}
