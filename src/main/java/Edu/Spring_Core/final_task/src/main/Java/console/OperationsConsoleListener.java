package Edu.Spring_Core.final_task.src.main.Java.console;


import Edu.Spring_Core.final_task.src.main.Java.operations.ConsoleOperationType;
import Edu.Spring_Core.final_task.src.main.Java.operations.OperationCommand;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class OperationsConsoleListener {

    private final Scanner scanner;
    private final Map<ConsoleOperationType, OperationCommand> commands =
            new EnumMap<>(ConsoleOperationType.class);

    public OperationsConsoleListener(Scanner scanner, List<OperationCommand> commands) {
        this.scanner = scanner;
        for (OperationCommand command : commands) {
            this.commands.put(command.getType(), command);
        }
    }

    public void listen() {
        while (true) {
            printMenu();

            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            ConsoleOperationType type;
            try {
                type = ConsoleOperationType.valueOf(line.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Неизвестная команда: " + line);
                continue;
            }

            if (type == ConsoleOperationType.QUIT) {
                return;
            }

            OperationCommand command = commands.get(type);

            try {
                command.execute(scanner);
            } catch (RuntimeException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Доступные команды: " + java.util.Arrays.toString(ConsoleOperationType.values()));
        System.out.print("Введите команду: ");
    }
}
