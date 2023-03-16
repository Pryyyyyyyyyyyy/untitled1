/*Этот код позволяет пользователю ввести основание треугольника и выводит
        на экран заполненный и пустой треугольники. Для вывода заполненного
        треугольника используется двойной цикл, который поочередно выводит
        символы * в каждую строку. Для вывода пустого треугольника используется тот же
        двойной цикл, но при выводе символов * выполняется проверка на то, является ли это
        символом в треугольнике или нет.
        Если да, то выводится символ *, иначе - пробел. */


import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int base = scanner.nextInt();

        // заполненный треугольник
        for (int i = base; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // пустой треугольник
        for (int i = base; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (i == 1 || j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
