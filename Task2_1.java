import java.util.Scanner;
import java.util.regex.Pattern;

public class Task2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите email: ");
        String email = scanner.nextLine();
        
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        
        if (Pattern.matches(regex, email)) {
            System.out.println("Email корректный.");
        } else {
            System.out.println("Email НЕКОРРЕКТНЫЙ.");
        }
        scanner.close();
    }
}
