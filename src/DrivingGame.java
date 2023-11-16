import java.util.Scanner;

public class DrivingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("DRIVING");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        if (name.isEmpty()) {
            System.out.println("Invalid name. Goodbye.");
            return;
        }

        Player player = new Player(name);
        Car myCar = new Car("Petrol");
        Game game = new Game(player, myCar);
        game.startGame();

    }
}
