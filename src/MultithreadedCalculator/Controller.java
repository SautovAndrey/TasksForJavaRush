package MultithreadedCalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    // Добавим комментарий к первой строке кода, инициализирующей переменные представления и диспетчера задач.
private final View view;
private final TaskManager taskManager;

// Добавим комментарий для конструктора класса Controller, принимающего два параметра.
public Controller(View view, TaskManager taskManager) {
    this.view = view;
    this.taskManager = taskManager;
}
    public void run() {
        // Выводим меню на консоль
        view.displayMenu();

        // Читаем пользовательский ввод
        int input = view.readInput();

        // Пока пользователь не выберет операцию "Запуск выполнения всех задач"
        while (input != View.Operation.ExecutionStart.getCode()) {
            // Если пользователь ввел некорректный код операции
            if (input < 1 || input > 4) {
                System.out.println("Некорректный код операции. Попробуйте еще раз.");
            } else {
                // Получаем тип операции, соответствующий коду, введенному пользователем
                View.Operation operation = View.Operation.values()[input - 1];
                OperationType operationType = operation.getOperationType();

                // Читаем пользовательский ввод для набора чисел
                ArrayList<Double> numbers = new ArrayList<>();
                System.out.println("Введите числа, разделенные пробелами:");
                Scanner scanner = new Scanner(System.in);
                String inputNumbers = scanner.nextLine();
                String[] numberStrings = inputNumbers.split(" ");
                for (String numberString : numberStrings) {
                    try {
                        double number = Double.parseDouble(numberString);
                        numbers.add(number);
                    } catch (NumberFormatException e) {
                        System.out.println("Введено некорректное число: " + numberString);
                    }
                }

                // Создаем новую задачу и добавляем ее в менеджере задач
                Task task = new Task(operationType, numbers);
                taskManager.addTask(task);
            }

            // Предлагаем пользователю выбрать операцию снова
            System.out.println("Нажмите Enter, чтобы выбрать операцию, или 'Запуск выполнения всех задач', чтобы закончить");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            if (line.equals("")) {
                view.displayMenu();
                input = view.readInput();
            } else if (line.equals("5")) {
                break;
            } else {
                System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }

        // Запускаем все задачи в менеджере задач
        taskManager.runTasks();
    }
}
