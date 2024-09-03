import java.util.ArrayList;

public class L03GenericCollection {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Volvo");

        System.err.println(cars.get(0));
        System.err.println(cars);
    }
}
