import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");

        var scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!"quit".equals(input)) {
            System.out.println("Unknown command");
            input = scanner.nextLine();
        }
    }
}
