package homework;

import org.jetbrains.annotations.NotNull;

/*
Этот метод принимает массив целых чисел arr в качестве параметра и выводит на экран
        все четные числа и нечетные числа в отдельных списках.
        Сначала выводятся все четные числа, а затем все нечетные числа.
        Чтобы проверить, что этот метод работает правильно,
        можно вызвать его с массивом целых чисел в качестве аргумента:
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printEvenAndOdd(arr);
*/
public class Ex2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printEvenAndOdd(arr);
    }

    public static void printEvenAndOdd(int[] arr) {
        System.out.print("Even numbers: ");
        for (int num : arr) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.print("Odd numbers: ");
        for (int num : arr) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}
