import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Assignment {
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            double num = sc.nextDouble();
            if (num == 0) {
                break;
            } else {
                numbers.add(num);
            }
        }

        // Calc the mean, median and mode
        double sum = 0.0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        double mean = sum / numbers.size();
        System.out.println("Mean = " + mean);

        // Median
        double median = 0.0;
        Collections.sort(numbers);
        if (numbers.size() % 2 == 0) {
            median = (numbers.get(numbers.size() / 2) + numbers.get((numbers.size() / 2) - 1)) / 2;
        } else {
            median = numbers.get(numbers.size() / 2);
        }
        System.out.println("Median = " + median);

        // Mode
        double mode = 0;
        int maxCount = 0;
        int currentCount = 0;

        for (int i = 0; i < numbers.size(); i++) {
            currentCount = 0;
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) == numbers.get(i)) {
                currentCount++;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                mode = numbers.get(i);
            }
        }

        System.out.println("Mode = " + mode);

        }
}
