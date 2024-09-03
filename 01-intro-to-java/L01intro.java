public class L01intro {
    // the main method is the entry point of the program
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Must specify the type of the variable and cannot be changed
        int myNum = 5;

        // Decimal numbers -> use double more often
        double myDoubleNum = 5.99; // for decimals, 8 bytes, more precise
        float myFloatNum = 5.99f; // put f at the back, else Java will assume its a doube

        // String (must be defined with Double Quotes)
        String myText = "Hello";

        // But char uses single quotes -> represents a single character
        char myLetter = 'D';

        // Boolean
        boolean myBool = true;

        System.out.println("Integer: " + myNum);
    }

}