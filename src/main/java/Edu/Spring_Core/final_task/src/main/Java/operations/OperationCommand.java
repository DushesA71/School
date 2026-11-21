package Edu.Spring_Core.final_task.src.main.Java.operations;


import java.util.Scanner;

public interface OperationCommand {
    ConsoleOperationType getType();

    void execute(Scanner scanner);
}