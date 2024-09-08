import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface ShapeBehavior {
    double getArea();
}

interface Drawable {
    String getDetail(int index);
}

abstract class Shapes implements ShapeBehavior, Drawable {
    private String name;

    public Shapes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Rectangle extends Shapes {
    private int x, y;
    private int length, width;

    public Rectangle(int x, int y, int length, int width) {
        super("Rectangle");
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getBottomRightX() {
        return x + length;
    }

    public int getBottomRightY() {
        return y + width;
    }

    public double getArea() {
        return length * width;
    }

    public String getDetail(int index) {
        return String.format("%d. %s -> Top-left: (%d, %d), Bottom-right: (%d, %d), Area: %.2f",
                             index+1, getName(), getX(), getY(), getBottomRightX(), getBottomRightY(), getArea());
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

class Circle extends Shapes {
    private int centerX, centerY;
    private int radius;

    public Circle(int centerX, int centerY, int radius) {
        super("Circle");
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String getDetail(int index) {
        return String.format("%d. %s -> Center: (%d, %d), Radius: %d, Area: %.2f",
                             index+1, getName(), getCenterX(), getCenterY(), getRadius(), getArea());
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

class TextLabel implements Drawable {
    private String fontFamily;
    private int fontSize;
    private int x, y;
    private String text;

    public TextLabel(String fontFamily, int fontSize, int x, int y, String text) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.x = x;
        this.y = y;
        this.text = text;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public int getFontSize() {
        return fontSize;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getText() {
        return text;
    }

    public String getDetail(int index) {
        return String.format("%d. Text label -> '%s', Font: %s, Size: %d, Top-left: (%d, %d)",
                             index+1, getText(), getFontFamily(), getFontSize(), getX(), getY());
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setText(String text) {
        this.text = text;
    }
}

public class Assignment {
    private static List<Drawable> drawables = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter a shape (rectangle/circle/text) or type '-' to quit:");
            String type = scanner.nextLine();

            if (type.equals("-")) {
                break;
            } else if (type.equalsIgnoreCase("rectangle")) {
                enterRectangle();
            } else if (type.equalsIgnoreCase("circle")) {
                enterCircle();
            } else if (type.equalsIgnoreCase("text")) {
                enterText();
            } else {
                System.out.println("Invalid shape.");
            }
        }

        while (!drawables.isEmpty()) {
            showDrawables();
            System.out.println("Enter the index of the drawable you want to edit or '-' to quit:");

            String input = scanner.nextLine();

            if (input.equals("-")) {
                break;
            }

            int index;
            try {
                index = Integer.parseInt(input) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid index or '-'.");
                continue;
            }

            if (index < 0 || index >= drawables.size()) {
                System.out.println("Index out of bounds. Please enter a valid index.");
                continue;
            }

            
            Drawable drawable = drawables.get(index);

            if (drawable instanceof Rectangle) {
                editRectangle((Rectangle) drawable);
            } else if (drawable instanceof Circle) {
                editCircle((Circle) drawable);
            } else if (drawable instanceof TextLabel) {
                editText((TextLabel) drawable);
            }
        }

        if (drawables.isEmpty()) {
            System.out.println("No drawables to display.");
        }
    }

    private static void enterRectangle() {
        System.out.print("Enter the x coordinate of the top-left corner: ");
        int x = scanner.nextInt();
        
        System.out.print("Enter the y coordinate of the top-left corner: ");
        int y = scanner.nextInt();
        
        System.out.print("Enter the length of the rectangle: ");
        int length = scanner.nextInt();

        scanner.nextLine();
        
        System.out.print("Enter the width of the rectangle: ");
        int width = scanner.nextInt();
        
        scanner.nextLine();
        
        drawables.add(new Rectangle(x, y, length, width));
        System.out.println("Rectangle added.");
    }

    private static void enterCircle() {
        System.out.print("Enter the x coordinate of the center: ");
        int centerX = scanner.nextInt();
        
        System.out.print("Enter the y coordinate of the center: ");
        int centerY = scanner.nextInt();
        
        System.out.print("Enter the radius of the circle: ");
        int radius = scanner.nextInt();
        
        scanner.nextLine();

        drawables.add(new Circle(centerX, centerY, radius));
        System.out.println("Circle added.");
    }

    private static void enterText() {
        System.out.print("Enter the font family: ");
        String fontFamily = scanner.nextLine();
        
        System.out.print("Enter the font size: ");
        int fontSize = scanner.nextInt();
        
        System.out.print("Enter the x coordinate of the top-left corner: ");
        int x = scanner.nextInt();
        
        System.out.print("Enter the y coordinate of the top-left corner: ");
        int y = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter the text: ");
        String enteredText = scanner.nextLine();
        
        drawables.add(new TextLabel(fontFamily, fontSize, x, y, enteredText));
        System.out.println("Text added.");
    }

    private static void showDrawables() {
        for (int i = 0; i < drawables.size(); i++) {
            System.out.println(drawables.get(i).getDetail(i));
        }
    }

    private static void editRectangle(Rectangle rectangle) {
        while (true) {
            System.out.println("Editing Rectangle:");
            System.out.println("1: Top-left coordinates");
            System.out.println("2: Length");
            System.out.println("3: Width");
            System.out.println("Enter the number of the property to edit or '-' to finish editing:");

            String choice = scanner.nextLine();

            if (choice.equals("-")) {
                break;
            }

            switch (choice) {
                case "1":
                    System.out.print("Enter new x coordinate: ");
                    rectangle.setX(scanner.nextInt());
                    System.out.print("Enter new y coordinate: ");
                    rectangle.setY(scanner.nextInt());
                    break;
                case "2":
                    System.out.print("Enter new length: ");
                    rectangle.setLength(scanner.nextInt());
                    break;
                case "3":
                    System.out.print("Enter new width: ");
                    rectangle.setWidth(scanner.nextInt());
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
                    break;
            }

            System.out.println("Rectangle updated.");
        }
    }

    private static void editCircle(Circle circle) {
        while (true) {
            System.out.println("Editing Circle:");
            System.out.println("1: Center coordinates");
            System.out.println("2: Radius");
            System.out.println("Enter the number of the property to edit or '-' to finish editing:");

            String choice = scanner.nextLine();

            if (choice.equals("-")) {
                break;
            }

            switch (choice) {
                case "1":
                    System.out.print("Enter new center x coordinate: ");
                    circle.setCenterX(scanner.nextInt());
                    System.out.print("Enter new center y coordinate: ");
                    circle.setCenterY(scanner.nextInt());
                    break;
                case "2":
                    System.out.print("Enter new radius: ");
                    circle.setRadius(scanner.nextInt());
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
                    break;
            }

            System.out.println("Circle updated.");
        }
    }

    private static void editText(TextLabel text) {
        while (true) {
            System.out.println("Editing TextLabel:");
            System.out.println("1: Font family");
            System.out.println("2: Font size");
            System.out.println("3: Top-left coordinates");
            System.out.println("4: Text");
            System.out.println("Enter the number of the property to edit or '-' to finish editing:");

            String choice = scanner.nextLine();

            if (choice.equals("-")) {
                break;
            }

            switch (choice) {
                case "1":
                    System.out.print("Enter new font family: ");
                    text.setFontFamily(scanner.nextLine());
                    break;
                case "2":
                    System.out.print("Enter new font size: ");
                    text.setFontSize(scanner.nextInt());
                    break;
                case "3":
                    System.out.print("Enter new x coordinate: ");
                    text.setX(scanner.nextInt());
                    System.out.print("Enter new y coordinate: ");
                    text.setY(scanner.nextInt());
                    break;
                case "4":
                    scanner.nextLine();
                    System.out.print("Enter new text: ");
                    text.setText(scanner.nextLine());
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
                    break;
            }

            System.out.println("TextLabel updated.");
        }
    }
}