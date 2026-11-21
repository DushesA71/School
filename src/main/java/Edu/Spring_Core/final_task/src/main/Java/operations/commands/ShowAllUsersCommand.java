package Edu.Spring_Core.final_task.src.main.Java.operations.commands;

import Edu.Spring_Core.final_task.src.main.Java.account.Account;
import Edu.Spring_Core.final_task.src.main.Java.operations.ConsoleOperationType;
import Edu.Spring_Core.final_task.src.main.Java.operations.OperationCommand;
import Edu.Spring_Core.final_task.src.main.Java.user.User;
import Edu.Spring_Core.final_task.src.main.Java.user.UserService;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Scanner;

@Component
public class ShowAllUsersCommand implements OperationCommand {

    private final UserService userService;

    public ShowAllUsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ConsoleOperationType getType() {
        return ConsoleOperationType.SHOW_ALL_USERS;
    }

    @Override
    public void execute(Scanner scanner) {
        Collection<User> users = userService.findAll();

        if (users.isEmpty()) {
            System.out.println("Пользователей нет.");
            return;
        }

        for (User user : users) {
            System.out.println("Пользователь: id=" + user.getId() + ", логин=" + user.getLogin());

            if (user.getAccountList().isEmpty()) {
                System.out.println("  счетов нет");
                continue;
            }

            for (Account account : user.getAccountList()) {
                System.out.println("  счёт: id=" + account.getId()
                        + ", баланс=" + account.getMoneyAmount());
            }
        }
    }
}
