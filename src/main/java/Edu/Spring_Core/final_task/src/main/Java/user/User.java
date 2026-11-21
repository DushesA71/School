package Edu.Spring_Core.final_task.src.main.Java.user;

import Edu.Spring_Core.final_task.src.main.Java.account.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {
    final int id;
    final String login;
    List<Account> accountList  = new ArrayList<>();

    public User(int id, String login, Account...accounts) {
        this.login = login;
        this.accountList.addAll(List.of(accounts));
        this.id = id;
    }
}
