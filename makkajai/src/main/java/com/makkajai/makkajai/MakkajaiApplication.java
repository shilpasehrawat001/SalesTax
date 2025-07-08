package com.makkajai.makkajai;

import com.makkajai.makkajai.model.Receipt;
import com.makkajai.makkajai.model.ReceiptItem;
import com.makkajai.makkajai.util.InputParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MakkajaiApplication {
	private static final Logger logger = LoggerFactory.getLogger(MakkajaiApplication.class);

	public static void main(String[] args) {
		String[][] testCases = {
				{
						"1 book at 12.49",
						"1 music CD at 14.99",
						"1 chocolate bar at 0.85"
				},
				{
						"1 imported box of chocolates at 10.00",
						"1 imported bottle of perfume at 47.50"
				},
				{
						"1 imported bottle of perfume at 27.99",
						"1 bottle of perfume at 18.99",
						"1 packet of headache pills at 9.75",
						"1 box of imported chocolates at 11.25"
				}
		};

		for (int i = 0; i < testCases.length; i++) {
			printReceipt("Output " + (i + 1), testCases[i]);
		}
	}

	private static void printReceipt(String title, String[] inputs) {
		System.out.println("\n" + title + ":");
		logger.info("Running receipt for {}", title);

		Receipt receipt = new Receipt();

		for (String line : inputs) {
			receipt.addItem(new ReceiptItem(InputParser.parseLine(line), 1));
		}

		receipt.printReceipt();
	}
}
