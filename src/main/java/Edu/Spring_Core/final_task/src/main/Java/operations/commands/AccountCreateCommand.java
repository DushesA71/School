package Edu.Spring_Core.final_task.src.main.Java.operations.commands;

import Edu.Spring_Core.final_task.src.main.Java.account.Account;
import Edu.Spring_Core.final_task.src.main.Java.account.AccountService;
import Edu.Spring_Core.final_task.src.main.Java.operations.ConsoleOperationType;
import Edu.Spring_Core.final_task.src.main.Java.operations.OperationCommand;
import Edu.Spring_Core.final_task.src.main.Java.user.User;
import Edu.Spring_Core.final_task.src.main.Java.user.UserService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AccountCreateCommand implements OperationCommand {

    private final AccountService accountService;
    private final UserService userService;

    public AccountCreateCommand(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public ConsoleOperationType getType() {
        return ConsoleOperationType.ACCOUNT_CREATE;
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.print("Введите id пользователя: ");
        int userId = Integer.parseInt(scanner.nextLine().trim());

        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь с id=" + userId + " не найден");
        }

        Account account = accountService.createAcc(userId);
        user.getAccountList().add(account);

        System.out.println("Создан счёт: id=" + account.getId()
                + ", владелец=" + user.getLogin()
                + ", баланс=" + account.getMoneyAmount());
    }
}
