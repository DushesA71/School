package Edu.Spring_Core.final_task.src.main.Java.account;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Account {
    int id;
    int userId;
    int moneyAmount;

    public Account(int id, int userId, int moneyAmount) {
        this.id = id;
        this.userId = userId;
        this.moneyAmount = moneyAmount;
    }
}
