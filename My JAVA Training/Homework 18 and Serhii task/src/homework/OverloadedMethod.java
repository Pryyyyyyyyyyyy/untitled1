package homework;
/*В данном коде создается класс OverloadedMethod, содержащий 5 перегруженных методов printMessage(),
        каждый из которых выполняет свою конкретную задачу в зависимости от переданных аргументов.
        Первый метод printMessage() не принимает никаких аргументов и выводит на консоль сообщение "Я пустой".
        Второй метод printMessage(String message) принимает одну строку и выводит ее на консоль.
        Третий метод printMessage(String[] messages) принимает массив строк и выводит все его
        значения через пробел.
        Четвертый метод printMessage(int[] numbers) принимает массив чисел и выводит на консоль сумму
        элементов массива.
        Пятый метод printMessage(int number, String message) принимает число и строку
        и выводит на консоль сообщение в формате: "Ваше сообщение - %%%%%%%%, ваше число - $",
        где "%%%%%%%%" и $ - это переданные строка и число соответственно.*/
class OverloadedMethod {

    public void printMessage() {
        System.out.println("Я пустой");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String[] messages) {
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message).append(" ");
        }
        System.out.println(sb.toString());
    }

    public void printMessage(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Сумма элементов массива равна: " + sum);
    }

    public void printMessage(int number, String message) {
        System.out.println("Ваше сообщение - " + message + ", ваше число - " + number);
    }
}
class Main {

    public static void main(String[] args) {
        OverloadedMethod om = new OverloadedMethod();
        om.printMessage(); // выводит на консоль сообщение "Я пустой"
        om.printMessage("Привет, мир!"); // выводит на консоль сообщение "Привет, мир!"
        om.printMessage(new String[] {"Java", "Python", "C++"}); // выводит на консоль "Java Python C++"
        om.printMessage(new int[] {1, 2, 3, 4, 5}); // выводит на консоль "Сумма элементов массива равна: 15"
        om.printMessage(10, "Hello World"); // выводит на консоль "Ваше сообщение - Hello World, ваше число - 10"
    }
}
