package homework;

public class ReverseDigits {
    public static void main(String[] args) {
        int number = 563;
        System.out.print("Reverse digits of " + number + " with double digits: ");
        printDigits(number);
    }

    public static void printDigits(int n) {
        if (n < 10) {
            System.out.print(n + "" + n + " ");
        } else {
            int lastDigit = n % 10;
            System.out.print(lastDigit + "" + lastDigit + " ");
            printDigits(n / 10);
            System.out.print(lastDigit + "" + lastDigit + " ");
        }
    }
}
