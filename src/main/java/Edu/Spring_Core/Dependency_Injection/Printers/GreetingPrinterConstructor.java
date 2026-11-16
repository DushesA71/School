package Edu.Spring_Core.Dependency_Injection.Printers;

import Edu.Spring_Core.Dependency_Injection.GreetingService;
import org.springframework.stereotype.Component;

@Component
public class GreetingPrinterConstructor {
    GreetingService service;

    public GreetingPrinterConstructor(GreetingService service){
        this.service = service;
    }

    public void printGreet(){
        System.out.println(service.greet("Андрей"));
    }
}
