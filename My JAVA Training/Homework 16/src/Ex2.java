
/*В этом решении мы используем класс Scanner, чтобы прочитать строку, введенную пользователем.
        Затем мы объявляем переменную count для подсчета количества символов 'a' и инициализируем ее значением 0.
        Также мы объявляем переменную i, которую будем использовать в качестве счетчика цикла while.
        Внутри цикла while мы проверяем каждый символ строки inputString.
        Если текущий символ равен 'a', мы увеличиваем значение переменной count.
        В конце мы выводим количество символов 'a', найденных в строке, на экран.*/

import java.util.Scanner;

public class Ex2  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String inputString = scanner.nextLine();

        int count = 0;
        int i = 0;

        while (i < inputString.length()) {
            if (inputString.charAt(i) == 'a') {
                count++;
            }
            i++;
        }

        System.out.println("Количество символов 'a' в строке: " + count);
    }
}
