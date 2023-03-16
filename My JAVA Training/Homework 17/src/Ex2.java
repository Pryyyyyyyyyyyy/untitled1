/*В этом коде мы создаем массив из 10 целых чисел,
        заполняем его случайными числами, затем запрашиваем у пользователя число,
        которое нужно найти в массиве. Затем мы проходим по всем элементам массива,
        и если находим искомое число, устанавливаем флаг found в true и выходим из цикла.
        В конце выводим сообщение о том, было найдено искомое число или нет.*/

import java.util.Random;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();

        // заполняем массив случайными числами
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для поиска: ");
        int num = scanner.nextInt();

        // проверяем, есть ли число в массиве
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Число " + num + " найдено в массиве");
        } else {
            System.out.println("Число " + num + " не найдено в массиве");
        }
    }
}
