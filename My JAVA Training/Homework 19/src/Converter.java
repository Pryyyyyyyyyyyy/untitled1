import java.util.Scanner;

public class Converter {
    private String name;

    public Converter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void convertToInt(String value) {
        try {
            int intValue = Integer.parseInt(value);
            System.out.println("Result: " + intValue);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + value + " is not a valid integer");
        }
    }

    public void convertToDouble(String value) {
        try {
            double doubleValue = Double.parseDouble(value);
            System.out.println("Result: " + doubleValue);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + value + " is not a valid double");
        }
    }

    public void convertToString(Object value) {
        System.out.println("Result: " + value.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter("MyConverter");

        System.out.println("Welcome to " + converter.getName() + "!");
        System.out.println("Please enter a value to convert: ");

        String value = scanner.nextLine();

        if (value.equals("true") || value.equals("false")) {
            System.out.println("Input value is boolean");
        } else {
            converter.convertToInt(value);
            converter.convertToDouble(value);
            converter.convertToString(value);
        }
    }
}
