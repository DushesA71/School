package Edu.Spring_Core.final_task.src.main.Java.console;

import org.springframework.stereotype.Component;

@Component
public class ConsoleInput {

    private final OperationsConsoleListener listener;

    public ConsoleInput(OperationsConsoleListener listener) {
        this.listener = listener;
    }

    public void run() {
        System.out.println("Добро пожаловать в банковское приложение.");
        listener.listen();
    }
}
