import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введи текст:");
        String text = scan.nextLine();

        String RealText = text.replaceAll("[0-9]", " ");
        StringTokenizer wordTokenizer = new StringTokenizer(RealText, " ,.!?;:-");
        int slova = wordTokenizer.countTokens();

        int cifri = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= '0' && c <= '9') {
                cifri++;
            }
        }

        String numbersText = text.replaceAll("[^0-9]+", " ");
        StringTokenizer numberTokenizer = new StringTokenizer(numbersText);
        int chisla = numberTokenizer.countTokens();

        System.out.println("\nСтатистика:");
        System.out.println("Слов: " + slova);
        System.out.println("Цифр: " + cifri);
        System.out.println("Чисел: " + chisla);

        scan.close();
    }
}
