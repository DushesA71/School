package Edu.Spring_Core.IoC_ApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Описываем, как создать бин GreetingService
    @Bean
    public UserMessageService userMessageService() {
        return new UserMessageService();
    }

    // Описываем, как создать бин GreetingPrinter,
    // и говорим Spring: сюда нужно внедрить GreetingService
    @Bean
    public UserMessagePrinter userMessagePrinter(UserMessageService userMessageService) {
        return new UserMessagePrinter(userMessageService);
    }
}