package TextStatAnalyzer;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class Controller {

    private final View view;
    private final Map<String, Map<String, Integer>> statistics;

    public Controller(View view) {
        this.view = view;
        statistics = new HashMap<>();
    }

    // Метод для запуска приложения
    public void start() {
        try {
            List<String> filePaths = view.getInputPaths();
            List<CompletableFuture<Void>> futures = new ArrayList<>();
            for (String filePath : filePaths) {
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    try {
                        String text = new String(Files.readAllBytes(Paths.get(filePath)));
                        TextDataAnalyzer analyzer = new TextDataAnalyzer(text);
                        Map<String, Integer> fileStats = new HashMap<>();
                        fileStats.put("символы", analyzer.getNumberOfSymbols());
                        fileStats.put("пробелы", analyzer.getNumberOfSpaces());
                        fileStats.put("предложения", analyzer.getNumberOfSentences());
                        fileStats.put("слова", analyzer.getNumberOfWords());
                        synchronized (statistics) {
                            statistics.put(filePath, fileStats);
                        }
                    } catch (InvalidPathException e) {
                        view.showError("Неверный путь к файлу: " + filePath);
                    } catch (NoSuchFileException e) {
                        view.showError("Файл не найден: " + filePath);
                    } catch (IOException e) {
                        view.showError("Ошибка чтения файла: " + filePath);
                        e.printStackTrace();
                    }
                });
                futures.add(future);
            }
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
            view.showStatistics(statistics);
        } catch (IllegalArgumentException e) {
            view.showError("Ввод пуст");
        }
    }
}



