package Edu.Spring_Core.final_task.src.main.Java;

import Edu.Spring_Core.final_task.src.main.Java.config.ApplicationConfiguration;
import Edu.Spring_Core.final_task.src.main.Java.console.ConsoleInput;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        context.getBean(ConsoleInput.class).run();
    }
}
