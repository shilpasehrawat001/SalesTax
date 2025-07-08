package com.makkajai.makkajai;

import com.makkajai.makkajai.factory.ItemFactory;
import com.makkajai.makkajai.model.item.Item;
import com.makkajai.makkajai.model.receipt.Receipt;
import com.makkajai.makkajai.model.receipt.ReceiptItem;
import com.makkajai.makkajai.printer.ReceiptPrinter;
import com.makkajai.makkajai.util.InputParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * MakkajaiApplication.java
 *
 * This is the entry point of the Sales Tax application.
 *
 * Responsibilities:
 * - Reads user input from the console line by line.
 * - Uses InputParser to extract item details (quantity, name, price).
 * - Uses ItemFactory to classify and create an Item (based on import status and exemption keywords).
 * - Aggregates all ReceiptItems into a Receipt.
 * - Terminates input after two consecutive blank lines.
 * - Delegates printing logic to ReceiptPrinter to display the final receipt.
 *
 * Design Consideration:
 * - Business logic (item classification, tax calculation) is delegated to respective classes.
 * - I/O handling is kept minimal in main and separated from the domain model logic.
 */

public class MakkajaiApplication {
	private static final Logger logger = LoggerFactory.getLogger(MakkajaiApplication.class);

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Receipt receipt = new Receipt();

		int emptyCount = 0;
		System.out.println("Enter items (press Enter twice to finish):");

		while (true) {
			String line = scanner.nextLine();

			if (line.trim().isEmpty()) {
				emptyCount++;
				if (emptyCount == 2) break;
				continue;
			} else {
				emptyCount = 0;
			}

			try {
				String[] parsed = InputParser.parseLine(line);
				int quantity = Integer.parseInt(parsed[0]);
				String name = parsed[1];
				double price = Double.parseDouble(parsed[2]);
				Item item = ItemFactory.createItem(name, price);
				receipt.addItem(new ReceiptItem(item, quantity));
			} catch (Exception e) {
				System.out.println("Error parsing line: " + e.getMessage());
			}
		}

		logger.info("\nOutput:");
		ReceiptPrinter.printReceipt(receipt);
	}

}
