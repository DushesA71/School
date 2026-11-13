package Edu.Spring_Core.IoC_ApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        UserMessagePrinter printer = applicationContext.getBean(UserMessagePrinter.class);

        printer.printMessage("Fylhtq");
    }

}
