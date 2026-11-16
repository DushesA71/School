package Edu.Spring_Core.IoC_ApplicationContext;

public class UserMessageService {

    public String createMessage(String name) {
        return String.format("Привет, %s, добро пожаловать!", name);}
}
