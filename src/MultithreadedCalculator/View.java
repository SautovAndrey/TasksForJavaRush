package MultithreadedCalculator;

import java.util.Scanner;

public class View {
    // Перечисление операций
        enum Operation {
        // Каждая операция имеет свой код и соответствующее ей значение из перечисления OperationType
        ADDITION(1, OperationType.ADDITION),
        SUBTRACTION(2, OperationType.SUBTRACTION),
        MULTIPLICATION(3, OperationType.MULTIPLICATION),
        FACTORIAL(4, OperationType.FACTORIAL),
        ExecutionStart(5, null); // Операция "Запуск выполнения всех задач" не имеет соответствующего ей значения из перечисления OperationType

        private final int code;
        private final OperationType operationType; // Значение из перечисления OperationType, соответствующее операции

        // Конструктор операции
        Operation(int code, OperationType operationType) {
            this.code = code;
            this.operationType = operationType;
        }

        // Метод для получения кода операции
        public int getCode() {
            return code;
        }

        // Метод для получения значения из перечисления OperationType, соответствующего операции
        public OperationType getOperationType() {
            return operationType;
        }
    }

    // Метод для вывода меню на консоль
    public void displayMenu() {
        System.out.println("Меню:");
        // Проходим по всем операциям из перечисления Operation
        for (Operation operation : Operation.values()) {
            // Если операция не является операцией "Запуск выполнения всех задач", то выводим ее код и значение из перечисления OperationType
            if (operation.getOperationType() != null) {
                System.out.println(operation.getCode() + ". " + operation.getOperationType().getSymbol());
            } else { // Иначе выводим только код операции и "Запуск выполнения всех задач"
                System.out.println(operation.getCode() + ". Запуск выполнения всех задач");
            }
        }
    }

    // Метод для чтения пользовательского ввода
    public int readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
