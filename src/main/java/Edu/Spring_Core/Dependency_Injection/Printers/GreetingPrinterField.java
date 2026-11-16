package Edu.Spring_Core.Dependency_Injection.Printers;

import Edu.Spring_Core.Dependency_Injection.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GreetingPrinterField {
    @Autowired
    @Qualifier("friendlyGreetingService")
    GreetingService service;

    public GreetingPrinterField(){};

    public void printGreet(){
        System.out.println(service.greet("Андрей"));
    }
}
