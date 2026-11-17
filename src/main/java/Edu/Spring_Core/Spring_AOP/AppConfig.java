package Edu.Spring_Core.Spring_AOP;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("Edu.Spring_Core.Spring_AOP")
public class AppConfig {
}