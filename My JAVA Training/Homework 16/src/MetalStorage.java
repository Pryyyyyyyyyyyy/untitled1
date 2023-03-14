/*При запуске программы пользователь должен ввести вместимость склада (в кг).
        Затем программа начинает цикл, в котором запрашивается вес металла (в кг) для приемки на склад.
        Если вес металла меньше 5 кг, программа выдает предупреждение. Если вес металла больше,
        чем доступное место на складе, программа также выдает предупреждение.
        Если же вес металла подходит для приемки, программа вычитает его из доступного места на складе
        и выводит сообщение об успешной операции.
        Цикл продолжается до тех пор, пока на складе есть место.
        Когда место заканчивается, программа выводит сообщение о завершении работы.*/

import java.util.Scanner;

public class MetalStorage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите вместимость склада (в кг): ");
        int capacity = scanner.nextInt();
        int availableSpace = capacity;

        System.out.println("На складе доступно " + availableSpace + " кг места");

        while (availableSpace > 0) {
            System.out.print("Введите вес металла (в кг) для приемки на склад: ");
            int weight = scanner.nextInt();

            if (weight < 5) {
                System.out.println("Невозможно принять металл весом менее 5 кг");
            } else if (weight > availableSpace) {
                System.out.println("Невозможно принять металл. Недостаточно места на складе");
            } else {
                availableSpace -= weight;
                System.out.println("Принят металл весом " + weight + " кг. На складе осталось " + availableSpace + " кг места");
            }
        }

        System.out.println("Склад заполнен. Работа завершена.");
    }
}
