import java.util.Scanner;

public class Task1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        
        double entropy = calculateEntropy(input);
        System.out.printf("Вывод: %.2f\n", entropy);
        
        scanner.close();
    }

    public static double calculateEntropy(String str) {
        if (str == null || str.isEmpty()) {
            return 0.0;
        }
        
        int[] charCounts = new int[256];
        for (char c : str.toCharArray()) {
            charCounts[c]++;
        }
        
        double entropy = 0.0;
        int len = str.length();
        
        for (int count : charCounts) {
            if (count > 0) {
                double probability = (double) count / len;
                entropy -= probability * (Math.log(probability) / Math.log(2));
            }
        }
        return entropy;
    }
}
