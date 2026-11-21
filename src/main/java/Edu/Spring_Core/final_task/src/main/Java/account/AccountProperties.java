package Edu.Spring_Core.final_task.src.main.Java.account;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AccountProperties {
    @Value("${account.default-amount}") int defaultAmount;
    @Value("${account.transfer-commission}") double transferCommission;
}
