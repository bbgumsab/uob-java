import java.util.Scanner;

public class L08HealthStatus {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); // System.in => keyboard (by default)
        System.out.println("Enter your name: ");
        String name = sc.nextLine(); 
        System.out.println("Hello, " + name);

        // ask the user for the weight
        System.out.println("Enter your weight: ");
        double weight = sc.nextDouble();

        System.out.println("Enter your height (in m)");
        double height = sc.nextDouble();

        // calculate the bmi
        double bmi = weight / (height * height);
        
        System.out.println("Your BMI is " + bmi);

        // if/else-if
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi <= 25) {
            System.out.println("Normal weight");
        } else if (bmi <= 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }   
}