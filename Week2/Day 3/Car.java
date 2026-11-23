package LabExercise;

// INHERITANCE: Car extends Vehicle, so it gets all 4 fields and both methods
public class Car extends Vehicle {

    protected double insurancePerDay;

    public Car(String vehicleNumber, String model, double ratePerDay,
               int days, double insurancePerDay) {
        super(vehicleNumber, model, ratePerDay, days);  // runs Vehicle's constructor
        this.insurancePerDay = insurancePerDay;
    }

    // POLYMORPHISM: replaces Vehicle's calculateRent() with Car's own version
    @Override
    public double calculateRent() {
        return (ratePerDay + insurancePerDay) * days;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car | " + vehicleNumber + " | " + model + " | Days: " + days + " | Rent: " + calculateRent());
    }
}