import java.util.Scanner;
import java.util.regex.Pattern;

public class Task2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите IPv6 (полная форма): ");
        String ipv6 = scanner.nextLine();
        
        String regex = "^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";
        
        if (Pattern.matches(regex, ipv6)) {
            System.out.println("IPv6 корректный.");
        } else {
            System.out.println("IPv6 НЕКОРРЕКТНЫЙ.");
        }
        scanner.close();
    }
}
