package Edu.Spring_Core.Spring_AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        UserMessageService messager = applicationContext.getBean(UserMessageService.class);

        messager.createMessage("Фтвку");
        System.out.println((messager.getMessage(true, "G")));
    }
}
