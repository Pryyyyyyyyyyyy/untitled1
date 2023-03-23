import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Калькулятор запущен.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите действие: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Stop")) {
                System.out.println("Калькулятор закрыт.");
                break;
            }
            try {
                double result = evaluate(input);
                System.out.println(result);
            } catch (IllegalArgumentException e) {
                System.out.println("Введите корректное действие.");
            }
        }
    }

    public static double evaluate(String input) {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new IllegalArgumentException();
        }
        double operand1 = Double.parseDouble(tokens[0]);
        double operand2 = Double.parseDouble(tokens[2]);
        switch (tokens[1]) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException();
        }
    }
}
