package Edu.Spring_Core.Dependency_Injection.Services;

import Edu.Spring_Core.Dependency_Injection.GreetingService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FormalGreetingService implements GreetingService {
    public String greet(String name){
        return "Здравствуй, дорогой брат " + name + "!";
    };
}
