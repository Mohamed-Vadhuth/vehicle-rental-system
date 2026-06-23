import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    int id;
    String name;
    String type;
    double rentPerDay;
    boolean isAvailable;

    public Vehicle(int id, String name, String type, double rentPerDay) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
    }
}

public class VehicleRS{

    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Sample data
        vehicles.add(new Vehicle(101, "Honda City", "Car", 1500));
        vehicles.add(new Vehicle(102, "Activa 6G", "Bike", 500));
        vehicles.add(new Vehicle(103, "Swift", "Car", 1200));
        vehicles.add(new Vehicle(104, "Thar", "SUV", 2500));

        while (true) {

            System.out.println("\n===== VEHICLE RENTAL SYSTEM =====");
            System.out.println("1. View All Vehicles");
            System.out.println("2. Rent Vehicle");
            System.out.println("3. Return Vehicle");
            System.out.println("4. Cancel Rent ");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewVehicles();
                    break;

                case 2:
                    rentVehicle();
                    break;

                case 3:
                    returnVehicle();
                    break;

                case 4:
                    cancelRent();
                    break;

                case 5:
                    System.out.println("Thank you for using system!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Display all vehicles
    public static void viewVehicles() {

        System.out.println("\nID | Name | Type | Rent/Day | Status");

        for (Vehicle v : vehicles) {

            System.out.println(
                    v.id + " | " +
                    v.name + " | " +
                    v.type + " | " +
                    v.rentPerDay + " | " +
                    (v.isAvailable ? "Available" : "Rented"));
        }
    }

    // Insert (Rent Vehicle)
    public static void rentVehicle() {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();

        System.out.print("Enter number of days: ");
        int days = sc.nextInt();

        for (Vehicle v : vehicles) {

            if (v.id == id) {

                if (v.isAvailable) {

                    double bill = v.rentPerDay * days;
                    v.isAvailable = false;

                    System.out.println("\nVehicle Rented Successfully!");
                    System.out.println("Vehicle: " + v.name);
                    System.out.println("Days: " + days);
                    System.out.println("Total Bill: ₹" + bill);

                } else {
                    System.out.println("Vehicle already rented!");
                }

                return;
            }
        }

        System.out.println("Vehicle not found!");
    }

    // Update (Return Vehicle)
    public static void returnVehicle() {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();

        for (Vehicle v : vehicles) {

            if (v.id == id) {

                if (!v.isAvailable) {

                    v.isAvailable = true;

                    System.out.println("Vehicle returned successfully!");
                    System.out.println("Thank you for using " + v.name);

                } else {
                    System.out.println("This vehicle was not rented!");
                }

                return;
            }
        }

        System.out.println("Vehicle not found!");
    }

    // Delete (Cancel Rent)
    public static void cancelRent() {

        System.out.print("Enter Vehicle ID to cancel rent: ");
        int id = sc.nextInt();

        for (int i = 0; i < vehicles.size(); i++) {

            Vehicle v = vehicles.get(i);

            if (v.id == id) {

                vehicles.remove(i);

                System.out.println("Vehicle Rent Cancelled successfully!");
                System.out.println("Money Will Be Refunded Shortly");
                return;
            }
        }

        System.out.println("Vehicle not found!");
    }
}