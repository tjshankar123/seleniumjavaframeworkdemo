package InterviewQA;

// Static key word in Java

public class Car {
    // Static variable: shared by all Car objects
    public static int numberOfCarsCreated = 0;

    // Instance variable: unique to each Car object
    public String model;

    public Car(String model) {
        this.model = model;
        numberOfCarsCreated++; // Increment static variable on object creation
    }

    // Static method: can be called without creating a Car object
    public static void displayTotalCars() {
        System.out.println("Total cars created: " + numberOfCarsCreated);
    }

    // Instance method: requires a Car object to be called
    public void displayCarDetails() {
        System.out.println("Model: " + this.model);
    }

    public static void main(String[] args) {
        // Access static variable directly using class name
        System.out.println("Initial cars: " + Car.numberOfCarsCreated);

        Car car1 = new Car("Sedan");
        Car car2 = new Car("SUV");

        // Access static method directly using class name
        Car.displayTotalCars();

        // Access instance method using an object
        car1.displayCarDetails();
        car2.displayCarDetails();
    }
}
