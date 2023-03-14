/*
Сначала мы создаем объект Scanner для чтения ввода пользователя с клавиатуры.
        Затем мы запрашиваем у пользователя число от 1 до 7, используя метод nextInt() объекта Scanner.
        Затем мы используем оператор if-else-if для проверки введенного числа.
        Если число равно 1, то выводится "Понедельник", если 2 - "Вторник", и так далее.
        Если число не находится в диапазоне от 1 до 7, то выводится сообщение "Лучше бы сегодня была пятница".
*/


import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число от 1 до 7: ");
        int day = scanner.nextInt();

        if (day == 1) {
            System.out.println("Понедельник");
        } else if (day == 2) {
            System.out.println("Вторник");
        } else if (day == 3) {
            System.out.println("Среда");
        } else if (day == 4) {
            System.out.println("Четверг");
        } else if (day == 5) {
            System.out.println("Пятница");
        } else if (day == 6) {
            System.out.println("Суббота");
        } else if (day == 7) {
            System.out.println("Воскресенье");
        } else {
            System.out.println("Лучше бы сегодня была пятница");
        }
    }
}
