package pluralsight;


import dao.AdminUserDAO;
import dao.AdminUserDAOMysqlImpl;
import dao.VehiclesDAOMySqlImpl;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Dealership dealership;
    final Scanner scanner = new Scanner(System.in);

    BasicDataSource ds = new BasicDataSource();
    VehiclesDAOMySqlImpl vDao = new VehiclesDAOMySqlImpl(ds);

    private static void displayMenu() {
        System.out.println("""
                
                =======================================
                     WELCOME TO D & B USED CARS
                =======================================
                (0)     TO BUY/LEASE A NEW CAR
                (1)        FIND A VEHICLE
                (2)      LIST ALL VEHICLES
                (3)        ADD A VEHICLE
                (4)       REMOVE A VEHICLE
                (5)       EXIT DEALERSHIP
                """);
    }

    private static void displaySearchMenu() {
        System.out.println("""
                
                =======================================
                          SEARCH FOR A VEHICLE
                =======================================
                (1)        SEARCH BY MAKE
                (2)        SEARCH BY MODEL
                (3)        SEARCH BY COLOR
                (4)         SEARCH BY VIN
                (5)     SEARCH BY VEHICLE TYPE
                (6)       SEARCH BY MILEAGE
                (7)        SEARCH BY PRICE
                (8)        SEARCH BY YEAR
                (0)              EXIT
                """);
    }

    private void init() {
        ds.setUsername("root");
        ds.setUrl("jdbc:mysql://localhost:3306/cardealership");
        ds.setPassword("yearup");
    }

    public void showMainMenu() throws IOException {
        init();

        boolean appRunning = true;
        while (appRunning) {
            displayMenu();
            int userInput = scanner.nextInt();
            scanner.nextLine();
            switch (userInput) {
                case 0 -> buyOrLeaseCar();
                case 1 -> showSearchMenu();
                case 2 -> printVehicleList(vDao.findAllVehicle());
                case 3 -> addCar(scanner);
                case 4 -> removeCar(scanner);
                case 5 -> appRunning = false;
                default -> System.out.println("\nSORRY WRONG INPUT TRY AGAIN!");
            }
        }

    }

    public void showSearchMenu() {
        boolean inSearchMenu = true;
        while (inSearchMenu) {
            displaySearchMenu();
            int userInput = scanner.nextInt();
            scanner.nextLine();
            // uses a lambda switch statement for cleaner code
            switch (userInput) {
                case 1 -> searchByMake(scanner);
                case 2 -> searchByModel(scanner);
                case 3 -> searchByColor(scanner);
                case 4 -> searchByVin(scanner);
                case 5 -> searchByVehicleType(scanner);
                case 6 -> searchByMileage(scanner);
                case 7 -> searchByPrice(scanner);
                case 8 -> searchByYear(scanner);
                case 0 -> inSearchMenu = false;
                default -> {
                    System.out.println("SORRY INVALID INPUT TRY AGAIN!");
                    return;
                }
            }
        }
    }

    // method to print a list of vehicles
    private void printVehicleList(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    // method to search for car by make
    public void searchByMake(Scanner scanner) {
        System.out.println("\nPlease enter the make of the car you would like to search for: \n");
        String make = scanner.nextLine();
        printVehicleList(vDao.findVehicleByMake(make));
    }

    // method to search for car by model
    public void searchByModel(Scanner scanner) {
        System.out.println("\nPlease enter the model of the car you would like to search for: \n");
        String model = scanner.nextLine();
        printVehicleList(vDao.findVehicleByModel(model));
    }

    public void searchByColor(Scanner scanner) {
        System.out.println("\nEnter the color of the car that you would like to search for: \n");
        String color = scanner.nextLine();
        printVehicleList(vDao.findVehicleByColor(color));
    }

    public void searchByVin(Scanner scanner) {
        System.out.println("\nEnter the vin of the vehicle you would like to search for: \n");
        int vin = scanner.nextInt();
        printVehicleList(vDao.findVehicleByVin(vin));
    }

    public void searchByVehicleType(Scanner scanner) {
        System.out.println("\nEnter the type of vehicle that you would like to search for: \n");
        String type = scanner.nextLine();
        printVehicleList(vDao.findVehiclesByType(type));
    }

    public void searchByMileage(Scanner scanner) {
        System.out.println("\nEnter Minimum mileage: \n");
        int minMiles = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\nEnter Maximum mileage: \n");
        int maxMiles = scanner.nextInt();
        scanner.nextLine();
        printVehicleList(vDao.findVehiclesByMileage(minMiles, maxMiles));
    }

    public void searchByPrice(Scanner scanner) {
        System.out.println("\nEnter Minimum price: \n");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("\nEnter Maximum price: \n");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();
        printVehicleList(vDao.findVehiclesByPriceRange(minPrice, maxPrice));
    }

    public void searchByYear(Scanner scanner) {
        System.out.println("\nWhat is the lowest year vehicle that you would like: \n");
        int year = scanner.nextInt();
        scanner.nextLine();
        printVehicleList(vDao.findVehicleByYear(year));
    }

    // method to add a new car
    private void addCar(Scanner scanner) {
        System.out.println("VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Make: ");
        String make = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();
        System.out.println("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Color: ");
        String color = scanner.nextLine();
        System.out.println("Mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Vehicle Type: ");
        String vehicleType = scanner.nextLine();
        System.out.println("Price: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        boolean sold = false;
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, mileage, price, sold);
        dealership.addVehicle(vehicle);
        vDao.addVehicle(vehicle);
        System.out.println("\nVEHICLE ADDED!");

    }

    // method to remove car
    private void removeCar(Scanner scanner) throws IOException {
        System.out.println("Enter the vin of the vehicle you would like to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        vDao.removeVehicle(vin);
    }

    private void buyOrLeaseCar() throws IOException {
        AdminUserDAO aDao = new AdminUserDAOMysqlImpl(ds);

        System.out.println("WOULD LIKE TO BUY OR LEASE A VEHICLE: ");
        String leaseOrBuy = scanner.nextLine();
        System.out.println("PLEASE ENTER TODAY'S DATE (YYYYMMDD): ");
        String date = scanner.nextLine();
        System.out.println("PLEASE ENTER YOUR FIRST NAME: ");
        String buyerFirstName = scanner.nextLine();
        System.out.println("PLEASE ENTER YOUR FIRST NAME: ");
        String buyerLastName = scanner.nextLine();
        System.out.println("PLEASE ENTER YOUR EMAIL: ");
        String buyerEmail = scanner.nextLine();
        System.out.println("ENTER THE VIN OF THE VEHICLE WOULD YOU LIKE TO PURCHASE: ");
        int purchasedCar = scanner.nextInt();
        scanner.nextLine();
        if (leaseOrBuy.equalsIgnoreCase("buy")) {
            System.out.println("WOULD YOU LIKE TO FINANCE THE VEHICLE?");
            System.out.println("PLEASE ENTER 'YES' OR 'NO': ");
            String yesOrNo = scanner.nextLine();
            boolean userResponse = true;
            if (yesOrNo.equalsIgnoreCase("YES")) {
                userResponse = true;

            } else if (yesOrNo.equalsIgnoreCase("NO")) {
                userResponse = false;
            }
            SalesContract sc = new SalesContract(date, buyerFirstName, buyerLastName, buyerEmail, vDao.findVehicleByVin(purchasedCar).get(0), userResponse);
            aDao.addSale(sc);

        } else if (leaseOrBuy.equalsIgnoreCase("lease")) {
            LeaseContract lc = new LeaseContract(date, buyerFirstName, buyerLastName, buyerEmail, vDao.findVehicleByVin(purchasedCar).get(0));
            aDao.addLease(lc);
        }
    }

}




