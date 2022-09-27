import javax.swing.text.StyledEditorKit;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

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

    public static String freq(String path) throws IOException {
        String file = Files.readString(Paths.get(path)).toLowerCase().replaceAll("[^a-zA-Z ]", " ");
        String[] words = file.split(" ");
        String[] witness = new String[words.length];
        int witness_index = 0;
        String first = "";
        String second = "";
        String third = "";
        int first_count = 0;
        int second_count = 0;
        int third_count = 0;

        for (int i = 0; i < words.length; i++) {
            if (!Objects.equals(words[i], "")) {
                boolean already_done = Boolean.FALSE;

                for (int j = 0; j < witness_index; j++) {
                    if (witness[j] != null && witness[j].equals(words[i])) {
                        already_done = Boolean.TRUE;
                        break;
                    }
                }

                if (!already_done) {
                    int count = 0;

                    for (int h = i; h < words.length; h++) {
                        if (words[i].equals(words[h])) {
                            count += 1;
                        }
                    }

                    witness[witness_index] = words[i];
                    witness_index += 1;

                    System.out.println("test.");
                    if (count > first_count) {
                        third_count = second_count;
                        third = second;
                        second_count = first_count;
                        second = first;
                        first_count = count;
                        first = words[i];
                    } else if (count > second_count) {
                        third_count = second_count;
                        third = second;
                        second_count = count;
                        second = words[i];
                    } else if (count > third_count) {
                        third_count = count;
                        third = words[i];
                    }
                }
            }
        }

        return first+" "+second+" "+third;
    }

    public static void main(String[] args) {
        System.out.println("Bienvenue");
        var scanner = new Scanner(System.in);
        String input;

        while (!"quit".equals(input = scanner.nextLine())) {
            if ("fibo".equals(input)) {
                System.out.println("Choisir n, qui sera l'argument de la suite de Fibonacci:");
                System.out.println(fibo(scanner.nextInt()));
                scanner.nextLine();
            } else if ("freq".equals(input)) {
                System.out.println("Ecrire le chemin du fichier a anlyser:");
                String path = scanner.nextLine();
                try {
                    System.out.println(freq(path));
                } catch (IOException ex) {
                    System.out.println("Unreadable file: " + path);
                }
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
