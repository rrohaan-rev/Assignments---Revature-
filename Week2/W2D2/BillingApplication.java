package com.smartstore.billing;

import java.util.Scanner;

public class BillingApplication {

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

		double totalAmount = productPrice * quantity;
		double discountAmount = calculateDiscount(totalAmount);
		double discountPercentage = getDiscountPercentage(totalAmount);
		double finalAmount = totalAmount - discountAmount;

		printBill(customerName, productName, totalAmount,
				discountPercentage, discountAmount, finalAmount);

		scanner.close();
	}

	public static double calculateDiscount(double totalAmount) {
		double discountPercentage = getDiscountPercentage(totalAmount);
		return totalAmount * discountPercentage / 100;
	}

	public static double getDiscountPercentage(double totalAmount) {
		if (totalAmount >= 5000) {
			return 10.0;
		} else if (totalAmount >= 1000) {
			return 5.0;
		}
		return 0.0;
	}

	public static void printBill(String customerName, String productName,
			double totalAmount, double discountPercentage,
			double discountAmount, double finalAmount) {

		System.out.println("\n--- SmartStore Bill ---");
		System.out.println("Customer Name: " + customerName);
		System.out.println("Product Name: " + productName);
		System.out.printf("Total Amount: Rs. %.2f%n", totalAmount);
		System.out.printf("Discount Percentage: %.0f%%%n", discountPercentage);
		System.out.printf("Discount Amount: Rs. %.2f%n", discountAmount);
		System.out.printf("Final Amount: Rs. %.2f%n", finalAmount);
	}
}