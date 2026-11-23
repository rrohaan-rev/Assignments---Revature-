package LabExercise;

// INHERITANCE: Bike extends Vehicle
public class Bike extends Vehicle {

    public Bike(String vehicleNumber, String model, double ratePerDay, int days) {
        super(vehicleNumber, model, ratePerDay, days);  // Vehicle stores all 4 fields
    }

    // POLYMORPHISM: Bike's own version of calculateRent() with a 10% discount
    @Override
    public double calculateRent() {
        return super.calculateRent() * 0.9;
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike | " + vehicleNumber + " | " + model + " | Days: " + days + " | Rent: " + calculateRent());
    }
}