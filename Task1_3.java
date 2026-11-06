import java.util.Scanner;

public class Task1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите данные с датчиков:");
        String input = scanner.nextLine();
        
        System.out.print("Сортировать по (1 - id, 2 - температуре): ");
        int sortChoice = scanner.nextInt();
        
        String[] tokens = input.split("@");
        
        SensorResult[] results = calculateAverages(tokens);
        
        sortResults(results, sortChoice);
        
        System.out.println("Вывод:");
        for (SensorResult res : results) {
            System.out.printf("%02d %.1f\n", res.id, res.avgTemp);
        }
        
        scanner.close();
    }

    public static SensorResult[] calculateAverages(String[] tokens) {
        int[] sumTemps = new int[100];
        int[] counts = new int[100];
        
        for (String token : tokens) {
            if (token.length() >= 3) {
                try {
                    int id = Integer.parseInt(token.substring(0, 2));
                    int temp = Integer.parseInt(token.substring(2));
                    sumTemps[id] += temp;
                    counts[id]++;
                } catch (NumberFormatException e) {
                }
            }
        }
        
        int activeCount = 0;
        for (int i = 0; i < 100; i++) {
            if (counts[i] > 0) activeCount++;
        }
        
        SensorResult[] results = new SensorResult[activeCount];
        int index = 0;
        for (int i = 0; i < 100; i++) {
            if (counts[i] > 0) {
                results[index++] = new SensorResult(i, (double) sumTemps[i] / counts[i]);
            }
        }
        return results;
    }

    public static void sortResults(SensorResult[] results, int sortChoice) {
        for (int i = 0; i < results.length - 1; i++) {
            for (int j = 0; j < results.length - i - 1; j++) {
                boolean swapNeeded = false;
                if (sortChoice == 1) {
                    if (results[j].id > results[j + 1].id) swapNeeded = true;
                } else {
                    if (results[j].avgTemp > results[j + 1].avgTemp) swapNeeded = true;
                }
                
                if (swapNeeded) {
                    SensorResult temp = results[j];
                    results[j] = results[j + 1];
                    results[j + 1] = temp;
                }
            }
        }
    }
}

class SensorResult {
    int id;
    double avgTemp;

    public SensorResult(int id, double avgTemp) {
        this.id = id;
        this.avgTemp = avgTemp;
    }
}
