package MultithreadedCalculator;


import java.math.BigDecimal;
import java.util.ArrayList;

public class Task {
    //Объявление переменных
    private OperationType operation;
    private ArrayList<Double> numbers;

 // Этот конструктор инициализирует операции и нумерует поля класса Task.
public Task(OperationType operation, ArrayList<Double> numbers) {
    this.operation = operation;
    this.numbers = numbers;
}

   // Получить операцию
public OperationType getOperation() {
    try {
        // Возврат операции в случае успеха
        return operation;
    } catch (Exception e) {
        System.out.println("Ошибка получения номеров " + e);
        // Вернуть ноль в случае неудачи
        return null;
    }
}

// Получить номера
public ArrayList<Double> getNumbers() {
    try {
        // Вернуть числа в случае успеха
        return numbers;
    } catch (Exception e) {
        System.out.println("Error getting numbers: " + e);
        // Вернуть ноль в случае неудачи
        return null;
    }
}

// Установить операцию
public void setOperation(OperationType operation) {
    try {
        // Установить операцию в случае успеха
        this.operation = operation;
    } catch (Exception e) {
        System.out.println("Ошибка установки операции: " + e);
    }
}

// Установить номера
public void setNumbers(ArrayList<Double> numbers) {
    try {
        // Установить числа в случае успеха
        this.numbers = numbers;
    } catch (Exception e) {
        System.out.println("Ошибка установки номеров: " + e);
    }
}

// Выполнить операцию
public double execute() {
    BigDecimal result = BigDecimal.ZERO;
    String operationName = operation.toString();
    switch (operation) {
        case ADDITION:
            // Выполнить операцию над набором чисел
            for (double number : numbers) {
                result = result.add(BigDecimal.valueOf(number));
            }
            break;
        case SUBTRACTION:
            // Проверить, достаточно ли чисел для вычитания
            if (numbers.size() < 2) {
                throw new IllegalArgumentException("Для вычитания требуется не менее двух чисел");
            }
            // Установите результат на первое число и вычтите остальные
            result = BigDecimal.valueOf(numbers.get(0));
            for (int i = 1; i < numbers.size(); i++) {
                result = result.subtract(BigDecimal.valueOf(numbers.get(i)));
            }
            break;
        case MULTIPLICATION:
            // Установите результат равным единице и умножьте на каждое число
            result = BigDecimal.ONE;
            for (double number : numbers) {
                result = result.multiply(BigDecimal.valueOf(number));
            }
            break;
        case FACTORIAL:
            // Проверьте, указан ли хотя бы один номер
            if (numbers.isEmpty()) {
                throw new IllegalArgumentException("Для вычисления факториала требуется хотя бы одно число.");
            }
            // Итерация по числам и вычисление факториала
            for (double number : numbers) {
                // Проверить, является ли число отрицательным
                if (number < 0) {
                    throw new IllegalArgumentException("Не удается вычислить факториал отрицательного числа");
                }
                BigDecimal factorial = BigDecimal.ONE;
                for (int i = 1; i <= number; i++) {
                    factorial = factorial.multiply(BigDecimal.valueOf(i));
                }
                System.out.println("Результат операции ФАКТОРИАЛ:: " + factorial);
            }
            return result.doubleValue();
    }
    return result.doubleValue();
}
}










