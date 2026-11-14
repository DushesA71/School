package Edu.Spring_Core.Dependency_Injection;

import org.springframework.stereotype.Component;

@Component
public interface GreetingService {
    String greet(String name);
}
