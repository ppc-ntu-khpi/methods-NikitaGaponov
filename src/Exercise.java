package src.main.java;

/**
 * Клас для шифрування тексту шифром Цезаря
 * Шифр Цезаря — простий метод шифрування, в якому кожен символ замінюється
 * на символ, що знаходиться на N позицій праворуч в алфавіті
 */
public class Exercise {

    /**
     * Метод для шифрування тексту шифром Цезаря
     * 
     * @param text текст для шифрування
     * @param shift величина зсуву (може бути від'ємною для розшифрування)
     * @return зашифрований текст
     */
    private static String caesarCipher(String text, int shift) {
        // Оптимізуємо використання пам'яті, використовуючи StringBuilder
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Шифруємо лише літери, зберігаючи регістр
            if (Character.isLetter(ch)) {
                // Визначаємо базовий символ ('a' для малих літер, 'A' для великих)
                char base = Character.isLowerCase(ch) ? 'a' : 'A';

                // Зсуваємо символ циклічно в межах алфавіту (26 літер)
                // Додаємо 26 перед операцією % для коректної роботи з від'ємними зсувами
                char shifted = (char)(base + ((ch - base + shift + 26) % 26));

                result.append(shifted);
            } else {
                // Для не-літер (пробіли, знаки пунктуації тощо) зсув не виконуємо
                result.append(ch);
            }
        }

        return result.toString();
    }

    /**
     * Головний метод для шифрування тексту
     * 
     * @param args масив параметрів: текст для шифрування та величина зсуву
     * @return зашифрований текст
     */
    public static String Calculate(String[] args) {
        if (args.length != 2) {
            return "Потрібно два аргументи: текст для шифрування та величина зсуву";
        }

        try {
            String text = args[0];
            int shift = Integer.parseInt(args[1]);

            return caesarCipher(text, shift);
        } catch (NumberFormatException e) {
            return "Помилка: другий аргумент має бути цілим числом";
        }
    }
}
