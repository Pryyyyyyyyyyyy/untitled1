 /*В этом коде мы используем класс Scanner для считывания ввода пользователя с клавиатуры.
        Затем мы используем класс StringBuilder для склеивания слов в одно предложение.
        Мы продолжаем считывать слова, пока пользователь не введет слово "STOP".
        Затем мы выводим склеенное предложение в консоль.
*/
        import java.util.Scanner;

public class ConcatenateWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sentence = new StringBuilder();
        String word;
        while (true) {
            System.out.print("Введите слово (или STOP для окончания): ");
            word = scanner.nextLine();
            if (word.equals("STOP")) {
                break;
            }
            sentence.append(word);
            sentence.append(" ");
        }
        System.out.println("Вы ввели следующее предложение: " + sentence.toString());
    }
}

