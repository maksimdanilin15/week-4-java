import java.util.Scanner;

public class Task2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String input = scanner.nextLine();
        
        String result = input.replaceAll("(.)\\1{2,}", "$1");
        
        System.out.println("Вывод: " + result);
        scanner.close();
    }
}
