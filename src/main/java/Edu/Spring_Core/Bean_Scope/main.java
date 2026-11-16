package Edu.Spring_Core.Bean_Scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        JobRunner a1 = context.getBean(JobRunner.class);
        JobRunner a2 = context.getBean(JobRunner.class);

        System.out.println(a1 == a2); // true или false зависит от scope

        a1.runOnce();
        a1.runOnce();

        a1.runOnce2();
        a1.runOnce2();

        context.close();
    }
}