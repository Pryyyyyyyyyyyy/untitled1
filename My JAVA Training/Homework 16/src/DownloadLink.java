/*
В этой программе мы сначала запрашиваем у пользователя название программы и операционной системы.
        Затем мы используем оператор switch для определения соответствующей ссылки для скачивания в
        зависимости от выбранных программы и ОС. Если выбранная программа или
        ОС не соответствует ни одному из определенных вариантов, мы выводим сообщение об ошибке.
*/

import java.util.Scanner;

public class DownloadLink {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название программы (IntelliJ IDEA, Git, Java):");
        String programName = scanner.nextLine();

        System.out.println("Введите название операционной системы (Linux, macOS, Windows):");
        String osName = scanner.nextLine();

        String downloadLink;

        switch (programName) {
            case "IntelliJ IDEA":
                switch (osName) {
                    case "Linux":
                        downloadLink = "https://www.jetbrains.com/idea/download/#section=linux";
                        break;
                    case "macOS":
                        downloadLink = "https://www.jetbrains.com/idea/download/#section=mac";
                        break;
                    case "Windows":
                        downloadLink = "https://www.jetbrains.com/idea/download/#section=windows";
                        break;
                    default:
                        System.out.println("Такой ОС не существует");
                        return;
                }
                break;
            case "Git":
                switch (osName) {
                    case "Linux":
                        downloadLink = "https://git-scm.com/download/linux";
                        break;
                    case "macOS":
                        downloadLink = "https://git-scm.com/download/mac";
                        break;
                    case "Windows":
                        downloadLink = "https://git-scm.com/download/win";
                        break;
                    default:
                        System.out.println("Такой ОС не существует");
                        return;
                }
                break;
            case "Java":
                switch (osName) {
                    case "Linux":
                        downloadLink = "https://java.com/ru/download/linux_manual.jsp";
                        break;
                    case "macOS":
                        downloadLink = "https://java.com/ru/download/mac_download.jsp";
                        break;
                    case "Windows":
                        downloadLink = "https://java.com/ru/download/manual.jsp";
                        break;
                    default:
                        System.out.println("Такой ОС не существует");
                        return;
                }
                break;
            default:
                System.out.println("Такой программы не существует");
                return;
        }

        System.out.println("Ссылка для скачивания " + programName + " для " + osName + ": " + downloadLink);
    }
}
