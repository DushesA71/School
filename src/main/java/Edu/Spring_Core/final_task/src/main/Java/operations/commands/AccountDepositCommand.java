package Edu.Spring_Core.final_task.src.main.Java.operations.commands;

import Edu.Spring_Core.final_task.src.main.Java.account.Account;
import Edu.Spring_Core.final_task.src.main.Java.account.AccountService;
import Edu.Spring_Core.final_task.src.main.Java.operations.ConsoleOperationType;
import Edu.Spring_Core.final_task.src.main.Java.operations.OperationCommand;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AccountDepositCommand implements OperationCommand {

    private final AccountService accountService;

    public AccountDepositCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ConsoleOperationType getType() {
        return ConsoleOperationType.ACCOUNT_DEPOSIT;
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.print("Введите id счёта: ");
        int accountId = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Введите сумму: ");
        int amount = Integer.parseInt(scanner.nextLine().trim());

        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть больше нуля");
        }

        Account account = accountService.findById(accountId);
        accountService.toFund(account, amount);

        System.out.println("Счёт id=" + account.getId() + " пополнен. Баланс: " + account.getMoneyAmount());
    }
}
