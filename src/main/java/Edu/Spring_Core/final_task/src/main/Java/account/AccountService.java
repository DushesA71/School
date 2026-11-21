package Edu.Spring_Core.final_task.src.main.Java.account;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class AccountService {
    Map<Integer, Account> Accounts = new HashMap<Integer, Account>();
    private static final AtomicInteger Sequence = new AtomicInteger();
    AccountProperties accountProperties;

    public AccountService(AccountProperties accountProperties){
        this.accountProperties = accountProperties;
    }

    public Account createAcc(int UserId){
        int i = Sequence.incrementAndGet();
        Account acc = new Account(i, UserId, accountProperties.defaultAmount);
        Accounts.put(i, acc);
        return acc;
    }

    public Account findById(int id){
        Account acc = Accounts.get(id);
        if (acc == null) {
            throw new IllegalArgumentException("Счёт с id=" + id + " не найден");
        }
        return acc;
    }

    public void toFund(Account account, int fundSum){
        Account acc = Accounts.get(account.getId());
        acc.setMoneyAmount(acc.getMoneyAmount() + fundSum);
    }

    public void toCashout(Account account, int cashoutSum){
        Account acc = Accounts.get(account.getId());
        acc.setMoneyAmount(acc.getMoneyAmount() - cashoutSum);
    }

    public void toTransfer(Account Daccount, Account Caccount, int transtSum){
        Daccount.setMoneyAmount(Daccount.getMoneyAmount() - transtSum - (int)(transtSum * accountProperties.transferCommission));
        Caccount.setMoneyAmount(Caccount.getMoneyAmount() + transtSum);
    }
}
