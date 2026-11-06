import java.util.Scanner;

public class Task1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Что ищем: ");
        String searchStr = scanner.nextLine();
        
        System.out.println("Где ищем:");
        int totalCount = 0;
        
        for (int i = 0; i < 3; i++) {
            String text = scanner.nextLine();
            int index = 0;
            while ((index = text.indexOf(searchStr, index)) != -1) {
                totalCount++;
                index += 1; 
            }
        }
        
        System.out.println("Вывод:");
        System.out.println(totalCount);
        
        scanner.close();
    }
}
