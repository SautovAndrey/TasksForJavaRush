package TextStatAnalyzer;

public class TextDataAnalyzer {

    // Эти переменные хранят информацию о тексте, который проанализирован.
    private final String savedText;
    private int numberOfSymbols;
    private int numberOfWords;
    private int numberOfSentences;
    private int numberOfSpaces;

    public TextDataAnalyzer(String text) {
        this.savedText = text;
        analyzeText();
    }

    // Метод для анализа текста
    private void analyzeText() {
        numberOfSymbols = savedText.length();
        String[] words = savedText.split("\\s+");
        numberOfWords = words.length;
        String[] sentences = savedText.split("[.!?]+");
        numberOfSentences = sentences.length;
        numberOfSpaces = savedText.split("\\s+").length - 1;
    }

    // Методы для получения статистики о тексте
    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public int getNumberOfSpaces() {
        return numberOfSpaces;
    }
}
