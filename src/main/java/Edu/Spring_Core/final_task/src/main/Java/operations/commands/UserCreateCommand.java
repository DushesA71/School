package Edu.Spring_Core.final_task.src.main.Java.operations.commands;

import Edu.Spring_Core.final_task.src.main.Java.operations.ConsoleOperationType;
import Edu.Spring_Core.final_task.src.main.Java.operations.OperationCommand;
import Edu.Spring_Core.final_task.src.main.Java.user.User;
import Edu.Spring_Core.final_task.src.main.Java.user.UserService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserCreateCommand implements OperationCommand {

    private final UserService userService;

    public UserCreateCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ConsoleOperationType getType() {
        return ConsoleOperationType.USER_CREATE;
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.print("Введите логин: ");
        String login = scanner.nextLine().trim();
        if (login.isEmpty()) {
            throw new IllegalArgumentException("Логин не может быть пустым");
        }
        User user = userService.CreateUser(login);
        System.out.println("Создан пользователь: id=" + user.getId() + ", логин=" + user.getLogin());
    }
}

