package Edu.Spring_Core.Spring_AOP;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UserMessageService {

    String message;
    @NotNullArgs
    public void createMessage(String name) {
        message = String.format("Привет, %s, добро пожаловать!", name);}
    @NotNullArgs
    public String getMessage(Boolean isLower, String flag){
        if(isLower){
            return message.toLowerCase(Locale.ROOT);
        }
        else{
            return this.message;
        }
    }
}
