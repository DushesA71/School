package Edu.Spring_Core.final_task.src.main.Java.operations.commands;

import Edu.Spring_Core.final_task.src.main.Java.account.Account;
import Edu.Spring_Core.final_task.src.main.Java.account.AccountService;
import Edu.Spring_Core.final_task.src.main.Java.operations.ConsoleOperationType;
import Edu.Spring_Core.final_task.src.main.Java.operations.OperationCommand;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AccountTransferCommand implements OperationCommand {

    private final AccountService accountService;

    public AccountTransferCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ConsoleOperationType getType() {
        return ConsoleOperationType.ACCOUNT_TRANSFER;
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.print("Введите id счёта-источника: ");
        int fromId = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Введите id счёта-получателя: ");
        int toId = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Введите сумму: ");
        int amount = Integer.parseInt(scanner.nextLine().trim());

        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть больше нуля");
        }
        if (fromId == toId) {
            throw new IllegalArgumentException("Нельзя перевести средства на тот же счёт");
        }

        Account from = accountService.findById(fromId);
        Account to = accountService.findById(toId);

        if (from.getMoneyAmount() < amount) {
            throw new IllegalArgumentException(
                    "Недостаточно средств: на счёте " + from.getMoneyAmount() + ", запрошено " + amount);
        }

        accountService.toTransfer(from, to, amount);

        System.out.println("Перевод выполнен: " + amount + " со счёта " + fromId + " на счёт " + toId);
        System.out.println("Баланс отправителя: " + from.getMoneyAmount()
                + ", баланс получателя: " + to.getMoneyAmount());
    }
}
