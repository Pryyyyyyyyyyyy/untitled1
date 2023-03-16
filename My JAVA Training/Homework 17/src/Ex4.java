/* Создаем объект класса Scanner для чтения пользовательского ввода с клавиатуры.
        Запрашиваем у пользователя размер массива и проверяем, что он четный.
        Создаем массив нужного размера и заполняем его случайными числами в диапазоне от 0 до 100.
        Выводим на экран изначальный массив.
        Сортируем первую половину массива по возрастанию с помощью метода Arrays.sort().
        Сортируем вторую половину массива по убыванию с помощью метода Arrays.sort().
        Обмениваем элементы второй половины массива в обратном порядке, чтобы получить убывающую сортировку.
        Выводим на экран отсортированный массив.*/


import java.util.Arrays;
        import java.util.Scanner;

public class Ex4  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива (четное число): ");
        int size = scanner.nextInt();
        if (size % 2 != 0) {
            System.out.println("Ошибка: размер массива должен быть четным числом!");
            return;
        }
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println("Изначальный массив: " + Arrays.toString(array));
        Arrays.sort(array, 0, size / 2); // сортировка первой половины по возрастанию
        Arrays.sort(array, size / 2, size); // сортировка второй половины по убыванию
        for (int i = 0; i < size / 2 / 2; i++) { // обмен элементов второй половины в обратном порядке
            int temp = array[size / 2 + i];
            array[size / 2 + i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}
