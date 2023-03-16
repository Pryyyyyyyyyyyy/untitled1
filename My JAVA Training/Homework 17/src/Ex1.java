
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        String[] names = {"Петя", "Маша", "Алёна", "Федя", "Саша", "Антон", "Глеб"};
        int[] times = {10, 12, 14, 16, 18, 20};
        String[] places = {"школу", "магазин", "церковь", "тренажерный зал", "кино", "поликлинику"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите индекс имени: ");
        int nameIndex = scanner.nextInt();
        System.out.print("Введите индекс времени: ");
        int timeIndex = scanner.nextInt();
        System.out.print("Введите индекс места: ");
        int placeIndex = scanner.nextInt();

        String name = names[nameIndex];
        int time = times[timeIndex];
        String place = places[placeIndex];

        System.out.println(name + " будет идти в " + place + " в " + time + ":00");
    }
}
