
import java.util.Scanner;
        import java.util.Random;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scanner.nextInt();
        Random random = new Random();
        int randNum = random.nextInt(21) - 10;
        try {
            double result = divideNumbers(num, randNum);
            System.out.println("Число пользователя: " + num);
            System.out.println("Сгенерированное число: " + randNum);
            System.out.println("Результат деления: " + result);
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
        } catch (NegativeResultException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double divideNumbers(int num, int randNum) throws DivideByZeroException, NegativeResultException {
        if (randNum == 0) {
            throw new DivideByZeroException("Ошибка: случайное число равно нулю.");
        }
        double result = (double) num / randNum;
        if (result < 0) {
            throw new NegativeResultException("Ошибка: результат деления отрицательный.");
        }
        return result;
    }

    static class DivideByZeroException extends Exception {
        public DivideByZeroException(String message) {
            super(message);
        }
    }

    static class NegativeResultException extends Exception {
        public NegativeResultException(String message) {
            super(message);
        }
    }
}
