package Edu.Spring_Core.Dependency_Injection;

import Edu.Spring_Core.Dependency_Injection.Printers.GreetingPrinterConstructor;
import Edu.Spring_Core.Dependency_Injection.Printers.GreetingPrinterField;
import Edu.Spring_Core.Dependency_Injection.Printers.GreetingPrinterSetter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingPrinterSetter printer = applicationContext.getBean(GreetingPrinterSetter.class);

        printer.printGreet();

        GreetingPrinterConstructor printer2 = applicationContext.getBean(GreetingPrinterConstructor.class);

        printer2.printGreet();

        GreetingPrinterField printer3 = applicationContext.getBean(GreetingPrinterField.class);

        printer3.printGreet();

        applicationContext.close();
    }
}
