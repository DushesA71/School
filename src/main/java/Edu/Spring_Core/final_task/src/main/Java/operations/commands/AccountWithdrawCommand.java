package Edu.Spring_Core.final_task.src.main.Java.operations.commands;

import Edu.Spring_Core.final_task.src.main.Java.account.Account;
import Edu.Spring_Core.final_task.src.main.Java.account.AccountService;
import Edu.Spring_Core.final_task.src.main.Java.operations.ConsoleOperationType;
import Edu.Spring_Core.final_task.src.main.Java.operations.OperationCommand;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AccountWithdrawCommand implements OperationCommand {

    private final AccountService accountService;

    public AccountWithdrawCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ConsoleOperationType getType() {
        return ConsoleOperationType.ACCOUNT_WITHDRAW;
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
        if (account.getMoneyAmount() < amount) {
            throw new IllegalArgumentException(
                    "Недостаточно средств: на счёте " + account.getMoneyAmount() + ", запрошено " + amount);
        }

        accountService.toCashout(account, amount);

        System.out.println("Со счёта id=" + account.getId() + " снято. Баланс: " + account.getMoneyAmount());
    }
}
