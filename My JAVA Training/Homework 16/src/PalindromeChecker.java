/*
Программа запрашивает у пользователя ввод числа с клавиатуры,
        затем вызывает функцию isPalindrome, которая проверяет, является ли число палиндромом.
        Функция isPalindrome переворачивает число и сравнивает его с исходным числом,
        чтобы определить, является ли оно палиндромом. Если число является палиндромом,
        программа выводит сообщение "число является палиндромом",
        в противном случае программа выводит сообщение "число не является палиндромом".
*/

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        if (isPalindrome(number)) {
            System.out.println(number + " является палиндромом");
        } else {
            System.out.println(number + " не является палиндромом");
        }
    }

    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reversedNumber = 0;
        while (number > 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        return originalNumber == reversedNumber;
    }
}
