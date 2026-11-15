package Edu.Spring_Core.Bean_Lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("Edu.Spring_Core.Bean_Lifecycle")
public class AppConfig {

    @Bean
    public AppLogger AppLogger() {
        return new AppLogger();
    }

    @Scope("prototype")
    @Bean
    public OperationContext operationContext() {
        return new OperationContext();
    }
}