package com.makkajai.makkajai;

import com.makkajai.makkajai.model.Item;
import com.makkajai.makkajai.model.Receipt;
import com.makkajai.makkajai.model.ReceiptItem;


public class MakkajaiApplication {

	public static void main(String[] args) {
		Receipt receipt = new Receipt();

		// Sample inputs
		Item book = new Item("book", 12.49, false, true);
		Item musicCD = new Item("music CD", 14.99, false, false);
		Item chocolate = new Item("chocolate bar", 0.85, false, true);

		receipt.addItem(new ReceiptItem(book, 1));
		receipt.addItem(new ReceiptItem(musicCD, 1));
		receipt.addItem(new ReceiptItem(chocolate, 1));

		receipt.printReceipt();
	}
}