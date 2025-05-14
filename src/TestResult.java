package src.main.java;

/**
 * Клас для тестування шифрування методом Цезаря
 */
public class TestResult {

    /**
     * Головний метод для тестування
     * 
     * @param args параметри командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        // Тестуємо шифр Цезаря на різних вхідних даних
        String text = "Hello, World!";
        int shift = 3;

        String[] params = {text, Integer.toString(shift)};

        String result = Exercise.Calculate(params);

        System.out.println("Шифр Цезаря з зсувом " + shift);
        System.out.println("Вхідний текст: " + text);
        System.out.println("Зашифрований текст: " + result);

        // Тестуємо розшифрування (використовуємо від'ємний зсув)
        String[] decryptParams = {result, Integer.toString(-shift)};
        String decrypted = Exercise.Calculate(decryptParams);

        System.out.println("Розшифрований текст: " + decrypted);
    }
}
