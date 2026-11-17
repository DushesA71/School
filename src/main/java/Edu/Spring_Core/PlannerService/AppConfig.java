package Edu.Spring_Core.PlannerService;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("Edu.Spring_Core.PlannerService")
@PropertySource("classpath:application.properties")
public class AppConfig {
}
