package com.smartstore.billing;

import java.util.Scanner;

public class BillingApplicationOriginal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter customer name: ");
		String customerName = scanner.nextLine();

		System.out.print("Enter product name: ");
		String productName = scanner.nextLine();

		System.out.print("Enter product price: Rs. ");
		double productPrice = scanner.nextDouble();

		System.out.print("Enter quantity: ");
		int quantity = scanner.nextInt();

		// Calculate the total before discount.
		double totalAmount = productPrice * quantity;
		double discountPercentage = 0.0;

		// 10% for Rs. 5,000 and above, 5% from Rs. 1,000 to Rs. 4,999.
		if (totalAmount >= 5000) {
			discountPercentage = 10.0;
		} else if (totalAmount >= 1000) {
			discountPercentage = 5.0;
		}

		double discountAmount = totalAmount * discountPercentage / 100;
		double finalAmount = totalAmount - discountAmount;

		System.out.println("\n--- SmartStore Bill ---");
		System.out.println("Customer Name: " + customerName);
		System.out.println("Product Name: " + productName);
		System.out.printf("Total Amount: Rs. %.2f%n", totalAmount);
		System.out.printf("Discount Percentage: %.0f%%%n", discountPercentage);
		System.out.printf("Discount Amount: Rs. %.2f%n", discountAmount);
		System.out.printf("Final Amount: Rs. %.2f%n", finalAmount);

		scanner.close();

	}

}
