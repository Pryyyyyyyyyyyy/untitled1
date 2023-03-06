class Main3 {
    public static void main(String[] args) {
       /* int a = 7;
        int b = 9;
        a = a + b; // a = 7 + 9 = 16
        b = a - b; // b = 16 - 9 = 7
        a = a - b; // a = 16 - 7 = 9
        System.out.println("a = " + a);
        System.out.println("b = " + b);
*/
      /*  double chislitel = 7.0;
        double znamenatel = 5.0;
        int celayaChast = (int) (chislitel / znamenatel);
        int ostatok = (int) (chislitel % znamenatel);
        int znamenatelInt = (int) znamenatel;
        System.out.println("Целая часть равна - " + celayaChast);
        System.out.println("Остаток от деления равен - " + ostatok);
        System.out.println("Знаменатель равен - " + znamenatelInt);*/

       /* String string1 = "This line that i want to cut, cause it is too long";
        String string2 = string1.substring(0, 35);
        String string3 = string2.substring(0, 17) + "don't want to cut, cause it is perfect";
        System.out.println("Строка 1: " + string1);
        System.out.println("Длина строки 1: " + string1.length());
        System.out.println("Строка 2: " + string2);
        System.out.println("Длина строки 2: " + string2.length());
        System.out.println("Строка 3: " + string3);
        System.out.println("Длина строки 3: " + string3.length());*/

       /* String string = "Testing, is my favourite job";

        // Разбиваем строку на список слов

        String[] words = string.split(" ");*/

        // Выводим каждое слово и его длину

       /* for (int i = 0; i < words.length; i++) {
            String word = words[i].replaceAll(",", "");
            System.out.printf("Слово%d = %s, Длина этого слова = %d%n", i+1, word, word.length());
        }

        // Проверяем, является ли первое слово длиннее остальных
        int firstWordLength = words[0].replaceAll(",", "").length();
        int[] otherWordLengths = new int[words.length-1];
        for (int i = 1; i < words.length; i++) {
            otherWordLengths[i-1] = words[i].replaceAll(",", "").length();
        }
        int maxOtherWordLength = 0;
        for (int i = 0; i < otherWordLengths.length; i++) {
            if (otherWordLengths[i] > maxOtherWordLength) {
                maxOtherWordLength = otherWordLengths[i];
            }
        }
        if (firstWordLength > maxOtherWordLength) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
*/

/*                String text = "Completely random text in English. In it, we just need to determine how many times the character 'a' occurs there. And we can use the split method and the length method.";

                // Split the text into an array of words
                String[] words = text.split("\\s+");

                // Initialize a counter variable
                int count = 0;

                // Loop through each word in the array
                for (String word : words) {
                    // Loop through each character in the word
                    for (int i = 0; i < word.length(); i++) {
                        // Check if the character is 'a' or 'A'
                        if (word.charAt(i) == 'a' || word.charAt(i) == 'A') {
                            count++;
                        }
                    }
                }

                // Print the count of 'a' characters in the text
                System.out.println("The text contains " + count + " 'a' characters.");*/
/*
        String text = "Completely random text in English. In it, we just need to determine how many times the character 'a' occurs there. And we can use the split method and the length method.";

        // Convert the text to lowercase
        String lowerCaseText = text.toLowerCase();

        // Initialize a counter variable
        int count = 0;

        // Loop through each character in the lowercase text
        for (int i = 0; i < lowerCaseText.length(); i++) {
            // Check if the character is 'a'
            if (lowerCaseText.charAt(i) == 'a') {
                count++;
            }
        }

        // Print the count of 'a' characters in the text
        System.out.println("The text contains " + count + " 'a' characters.");*/
    }
}