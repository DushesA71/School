package Edu.Spring_Core.Dependency_Injection.Printers;

import Edu.Spring_Core.Dependency_Injection.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingPrinterSetter {

    GreetingService service;

    public GreetingPrinterSetter(){

    }

    @Autowired
    public void setService(GreetingService service){
        this.service = service;
    };

    public void printGreet(){
        System.out.println(service.greet("Андрей"));
    }
}
