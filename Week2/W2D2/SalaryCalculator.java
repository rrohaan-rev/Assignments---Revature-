package com.smartstore.billing;

import java.util.Scanner;

public class SalaryCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter employee ID: ");
		int employeeId = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter employee name: ");
		String employeeName = scanner.nextLine();

		System.out.print("Enter basic salary: Rs. ");
		double basicSalary = scanner.nextDouble();

		double hra = basicSalary * 20 / 100;
		double da = basicSalary * 10 / 100;
		double grossSalary = calculateGross(basicSalary, hra, da);
		double professionalTax = calculateProfessionalTax(grossSalary);
		double netSalary = grossSalary - professionalTax;

		System.out.println("\n--- Employee Salary Details ---");
		System.out.println("Employee ID: " + employeeId);
		System.out.println("Employee Name: " + employeeName);
		System.out.printf("Basic Salary: Rs. %.2f%n", basicSalary);
		System.out.printf("HRA (20%%): Rs. %.2f%n", hra);
		System.out.printf("DA (10%%): Rs. %.2f%n", da);
		System.out.printf("Gross Salary: Rs. %.2f%n", grossSalary);
		System.out.printf("Professional Tax: Rs. %.2f%n", professionalTax);
		System.out.printf("Net Salary: Rs. %.2f%n", netSalary);

		scanner.close();
	}

	// Calculates gross salary using basic salary, HRA and DA.
	public static double calculateGross(double basicSalary, double hra, double da) {
		return basicSalary + hra + da;
	}

	// Deducts Rs. 200 tax only when gross salary is above Rs. 20,000.
	public static double calculateProfessionalTax(double grossSalary) {
		if (grossSalary > 20000) {
			return 200.0;
		}
		return 0.0;
	}
}