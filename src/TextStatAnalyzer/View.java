package TextStatAnalyzer;

import java.util.*;

public class View {

    private final Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    // Метод для ввода путей к файлам
    public List<String> getInputPaths() {
        System.out.println("Введите пути к файлам строго ТОЛЬКО через запятую без пробелов:");
        String input = scanner.nextLine();
        try {
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Ввод пуст");
            }
            return Arrays.asList(input.split(","));
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
            return Collections.emptyList();
        }
    }

    // Метод для вывода статистики о тексте
    public void showStatistics(Map<String, Map<String, Integer>> statistics) {
        for (String file : statistics.keySet()) {
            System.out.println("Информация о файле " + file);
            Map<String, Integer> fileStats = statistics.get(file);
            System.out.println("Количество символов: " + fileStats.get("символы"));
            System.out.println("Количество пробелов: " + fileStats.get("пробелы"));
            System.out.println("Количество предложений: " + fileStats.get("предложения"));
            System.out.println("Количество слов: " + fileStats.get("слова"));
            System.out.println();
        }
    }

    // Метод для вывода ошибок
    public void showError(String message) {
        System.err.println(message);
    }
}

