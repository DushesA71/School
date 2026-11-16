package Edu.Spring_Core.Bean_Lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        AppLogger logger1 = applicationContext.getBean(AppLogger.class);
        AppLogger logger2 = applicationContext.getBean(AppLogger.class);
        System.out.println("logger1 == logger2 ? " + (logger1 == logger2));

        OperationContext ctx1 = applicationContext.getBean(OperationContext.class);
        OperationContext ctx2 = applicationContext.getBean(OperationContext.class);
        OperationContext ctx3 = applicationContext.getBean(OperationContext.class);
        System.out.println("ctx1 == ctx2 ? " + (ctx1 == ctx2));
        System.out.println("ctx2 == ctx3 ? " + (ctx2 == ctx3));

        applicationContext.close();
    }
}
