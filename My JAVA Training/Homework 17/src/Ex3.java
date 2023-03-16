/*
В этом коде мы используем класс Random, чтобы генерировать случайные числа от -50 до +50.
        Мы используем цикл for, чтобы заполнить массив и найти минимальный и максимальный элементы.
        Затем мы выводим найденные значения на консоль с помощью метода println класса System.out.
*/


import java.util.Random;

public class Ex3 {
    public static void main(String[] args) {
        int[] arr = new int[45];
        Random random = new Random();

        // заполнение массива случайными числами от -50 до +50
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(101) - 50;
        }

        // поиск минимального и максимального элементов
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // вывод на консоль минимального и максимального элементов
        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
    }
}
