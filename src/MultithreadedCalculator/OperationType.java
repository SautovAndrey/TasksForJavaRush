package MultithreadedCalculator;

public enum OperationType {
    ADDITION("Сложение"),
    SUBTRACTION("Вычитание"),
    MULTIPLICATION("Умножение"),
    FACTORIAL("Факториал");

    // Объявляем закрытую переменную final String с именем symbol
    private final String symbol;

    OperationType(String symbol) {
    // Сохраняем символ в переменной экземпляре
        this.symbol = symbol;
    }
    public String getSymbol() {
    // Возвращаем сохраненный символ
        return symbol;
    }
}


