import java.util.Scanner;

public class Launcher {
    public static int fibo(int n) {
        if (0 == n) {
            return 0;
        } else if (1 == n) {
            return 1;
        } else {
            return fibo(n-1) + fibo(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println("Bienvenue");
        var scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!"quit".equals(input)) {
            if ("fibo".equals(input)) {
                System.out.println("Choisir n, qui sera l'argument de la suite de Fibonacci");
                System.out.println(fibo((scanner.nextInt())));
                scanner.nextLine();
            } else {
                System.out.println("Unknown command");
            }

            input = scanner.nextLine();
        }
    }
}
