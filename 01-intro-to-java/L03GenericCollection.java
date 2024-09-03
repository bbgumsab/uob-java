import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class L03GenericCollection {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Volvo");

        System.err.println(cars.get(0));
        System.err.println(cars);

        Map<String, Integer> months = new HashMap<>();
        months.put("January", 1);
        months.put("February", 2);

        System.err.println(months.get("January"));
        System.err.println("There are " + months.get("February") + " days in February");

        // When using generic collection, data type in <> must be class equivalent
        ArrayList<Integer> numbers = new ArrayList<>(); // Capitalise int to Integer
    }
}
