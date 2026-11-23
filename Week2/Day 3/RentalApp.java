package LabExercise;

import java.util.Scanner;

public class RentalApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();

        // POLYMORPHISM: one Vehicle[] array holds both Car and Bike objects
        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {

            // keep asking until the user enters 1 or 2
            int type;
            while (true) {
                System.out.print("Enter type (1-Car, 2-Bike): ");
                type = sc.nextInt();
                if (type == 1 || type == 2) {
                    break;
                }
                System.out.println("Invalid type. Please enter 1 or 2.");
            }

            System.out.print("Enter Vehicle Number: ");
            String vehicleNumber = sc.next();

            System.out.print("Enter Model: ");
            String model = sc.next();

            System.out.print("Enter Rate per Day: ");
            double ratePerDay = sc.nextDouble();

            System.out.print("Enter Days: ");
            int days = sc.nextInt();

            if (type == 1) {
                System.out.print("Enter Insurance per Day: ");
                double insurancePerDay = sc.nextDouble();
                vehicles[i] = new Car(vehicleNumber, model, ratePerDay, days, insurancePerDay);
            } else {
                vehicles[i] = new Bike(vehicleNumber, model, ratePerDay, days);
            }
        }

        System.out.println("--- Rental Details ---");

        double totalRent = 0;

        // RUNTIME POLYMORPHISM: Java checks the real object (Car or Bike) and runs its version
        for (Vehicle v : vehicles) {
            v.displayDetails();
            totalRent += v.calculateRent();
        }

        System.out.println("Total Rent Collected: " + totalRent);

        sc.close();
    }
}