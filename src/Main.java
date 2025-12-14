import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введи текст:");
        String text = scan.nextLine();

        // 1. Считаем слова через StringTokenizer
        StringTokenizer wordTokenizer = new StringTokenizer(text, " ,.!?;:-");
        int slova = wordTokenizer.countTokens();

        // 2. Считаем цифры через StringTokenizer (разбиваем на отдельные символы)
        StringTokenizer charTokenizer = new StringTokenizer(text, "", true);
        int cifri = 0;
        while (charTokenizer.hasMoreTokens()) {
            String token = charTokenizer.nextToken();
            if (token.length() == 1) {
                char c = token.charAt(0);
                if (c >= '0' && c <= '9') {
                    cifri++;
                }
            }
        }

        // 3. Считаем числа через StringTokenizer
        // Сначала заменяем все НЕцифры на пробелы
        String numbersText = text.replaceAll("[^0-9]+", " ");
        // Затем разбиваем по пробелам
        StringTokenizer numberTokenizer = new StringTokenizer(numbersText);
        int chisla = numberTokenizer.countTokens();

        // Вывод
        System.out.println("\nСтатистика:");
        System.out.println("Слов: " + slova);
        System.out.println("Цифр: " + cifri);
        System.out.println("Чисел: " + chisla);

        scan.close();
    }
}