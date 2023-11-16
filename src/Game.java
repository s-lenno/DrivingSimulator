import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private Car car;
    private double distanceTraveled;
    private double fuelLevel;
    private int points;
    private boolean gameOver;

    public Game(Player player, Car car) {
        this.player = player;
        this.car = car;
        this.distanceTraveled = 0.0;
        this.fuelLevel = 100.0;
        this.points = 0;
        this.gameOver = false;
    }

    public void startGame() {
        System.out.println(player.getName() + ", let's drive.");

        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            System.out.println("\nMain Menu");
            System.out.println("0. About this game");
            System.out.println("1. Start the car");
            System.out.println("2. Drive the car");
            System.out.println("3. Describe the car");
            System.out.println("4. Stop the car");
            System.out.println("5. Refuel");
            System.out.println("6. Upgrade Car");
            System.out.println("7. Show Distance Traveled");
            System.out.println("8. Show Points");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    displayGameSummary();
                    break;
                case 1:
                    car.start();
                    break;
                case 2:
                    if (fuelLevel > 0) {
                        drive();
                    } else {
                        System.out.println("Out of fuel! Refuel to continue.");
                    }
                    break;
                case 3:
                    car.describe();
                    break;
                case 4:
                    car.stop();
                    break;
                case 5:
                    refuel();
                    break;
                case 6:
                    upgradeCar();
                    break;
                case 7:
                    showDistanceTraveled();
                    break;
                case 8:
                    showPoints();
                    break;
                case 9:
                    System.out.println("Exiting the program. Goodbye, " + player.getName() + "!");
                    gameOver = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 9.");
            }
        }
    }

    private void displayGameSummary() {
        System.out.println("=== About this game ===");
        System.out.println("\n" +
                "the car simulation game is a text-based console application that simulates the experience of owning and driving a car where you as the player have the opportunity to interact with various features related to your virtual car including starting the car driving the car with a random event system during driving such as encountering traffic getting a speed boost or finding shortcuts describing the car and its engine type stopping the car refueling to manage your car's fuel level upgrading the car showing the total distance traveled by your car monitoring points earned based on your driving performance and the option to exit the game whenever you're ready players can enjoy a mix of car management decision-making and random events creating an engaging and interactive experience in a simple text-based environment the game is designed to be a fun and dynamic simulation allowing players to explore various aspects of owning and driving a virtual car.");
        System.out.println("====================");
    }
    private void drive() {
        Random random = new Random();
        double distance = random.nextDouble() * 20.0;

        handleRandomEvent();

        distanceTraveled += distance;
        fuelLevel -= distance / 2.0;

        points += (int) distance;

        System.out.println("You drove " + String.format("%.2f", distance) + " miles.");
    }

    private void handleRandomEvent() {
        Random random = new Random();
        int eventChance = random.nextInt(100);

        if (eventChance < 20) {
            int eventType = random.nextInt(3);

            switch (eventType) {
                case 0:
                    System.out.println("Heavy traffic approaching - be careful.");
                    break;
                case 1:
                    System.out.println("The traffic is fluid, enjoy the journey.");
                    break;
                case 2:
                    System.out.println("There is a shortcut this way. Take this turn...");
                    fuelLevel += 10.0;
                    break;
            }
        }
    }

    private void refuel() {
        System.out.print("Enter the amount of fuel to add: ");
        Scanner scanner = new Scanner(System.in);
        double fuelToAdd = scanner.nextDouble();

        if (fuelToAdd > 0) {
            fuelLevel += fuelToAdd;
            System.out.println("Fuel added. Current fuel level: " + fuelLevel);
        } else {
            System.out.println("Invalid amount. Fuel not added.");
        }
    }

    private void upgradeCar() {
        System.out.println("Local garage");
        System.out.println("1. Get rear tints");
        System.out.println("2. Cut the springs");
        System.out.println("3. Remove dpf");
        System.out.println("4. Away on home");

        Scanner scanner = new Scanner(System.in);
        int customisationChoice = scanner.nextInt();

        switch (customisationChoice) {
            case 1:
                getRearTints();
                break;
            case 2:
                cutSprings();
                break;
            case 3:
                removeDPF();
                break;
            case 4:
                System.out.println("Returning to the main menu.");
                break;
            default:
                System.out.println("Invalid choice. No customisation performed.");
        }
    }

    private void getRearTints() {
        System.out.println("Get rear tints for your car:");
        System.out.println("Rear tints applied.");
    }

    private void cutSprings() {
        System.out.println("Cut the springs of your car:");
        System.out.println("Springs cut.");
    }

    private void removeDPF() {
        System.out.println("Remove the Diesel Particulate Filter (DPF) from your car:");
        System.out.println("DPF removed.");
    }



    private void showDistanceTraveled() {
        System.out.println("Total Distance Traveled: " + String.format("%.1f", distanceTraveled) + " miles.");
    }

    private void showPoints() {
        System.out.println("Current Points: " + points);
    }
}
