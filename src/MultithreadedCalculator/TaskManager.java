package MultithreadedCalculator;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    // Создаём список задач
private final List<Task> tasks;

public TaskManager(List<Task> tasks) { // Создаём конструктор для задач
    this.tasks = tasks;//not sure it makes sense to pass arrayList of tasks, it can be created here
}
public void addTask(Task task) {    // Добавляем задачу в список задач
    tasks.add(task);
}

    public void runTasks() {
        // Создаем список для хранения потоков
        List<Thread> threads = new ArrayList<>();
        // Для каждой задачи в списке создаем новый поток
        for (Task task : tasks) {
            Thread thread = new Thread(() -> {
                // Выполняем задачу и получаем результат
                double result = task.execute();
                // Получаем название операции
                String operationName = switch (task.getOperation()) {
                    case ADDITION -> "СЛОЖЕНИЕ";
                    case SUBTRACTION -> "ВЫЧИТАНИЕ";
                    case MULTIPLICATION -> "УМНОЖЕНИЕ";
                    case FACTORIAL -> "ФАКТОРИАЛ";
                };
                // Выводим результат выполнения задачи в консоль
                if (task.getOperation() != OperationType.FACTORIAL) {
                    System.out.println("Результат выполнения задачи " + operationName + ": " + BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP));
                }
            });

            // Добавляем поток в список потоков
            threads.add(thread);
            // Запускаем поток в многопоточном режиме
            thread.start();
        }
    }
}