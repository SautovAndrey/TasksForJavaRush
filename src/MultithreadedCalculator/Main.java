package MultithreadedCalculator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        TaskManager taskManager = new TaskManager(new ArrayList<>());

// Создаем объект Controller с объектами View и TaskManager
        Controller controller = new Controller(view, taskManager);

// Запускаем контроллер
        controller.run();
    }
}

