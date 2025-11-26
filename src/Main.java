import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для анализа:");
        String text = scanner.nextLine();

        // Сбор статистики
        int wordCount = countWords(text);
        int digitCount = countDigits(text);
        int numberCount = countNumbers(text);

        // Вывод результатов
        System.out.println("\nРезультаты анализа текста:");
        System.out.println("Количество слов: " + wordCount);
        System.out.println("Количество цифр: " + digitCount);
        System.out.println("Количество чисел: " + numberCount);

        scanner.close();
    }

    // Метод для подсчета слов
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        // Разделяем текст по пробелам и знакам препинания
        String[] words = text.trim().split("\\s+");
        int count = 0;

        for (String word : words) {
            // Убираем знаки препинания вокруг слова и проверяем, что это действительно слово
            String cleanWord = word.replaceAll("^[^a-zA-Zа-яА-Я0-9]+|[^a-zA-Zа-яА-Я0-9]+$", "");
            if (!cleanWord.isEmpty()) {
                count++;
            }
        }

        return count;
    }

    // Метод для подсчета отдельных цифр
    public static int countDigits(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }

        return count;
    }

    // Метод для подсчета чисел (последовательностей цифр)
    public static int countNumbers(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        // Используем регулярное выражение для поиска последовательностей цифр
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}