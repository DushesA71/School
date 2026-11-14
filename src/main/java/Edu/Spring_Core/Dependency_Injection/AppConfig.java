package Edu.Spring_Core.Dependency_Injection;

import Edu.Spring_Core.Dependency_Injection.Printers.GreetingPrinterConstructor;
import Edu.Spring_Core.Dependency_Injection.Printers.GreetingPrinterField;
import Edu.Spring_Core.Dependency_Injection.Printers.GreetingPrinterSetter;
import Edu.Spring_Core.Dependency_Injection.Services.FormalGreetingService;
import Edu.Spring_Core.Dependency_Injection.Services.FriendlyGreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"Edu.Spring_Core.Dependency_Injection.Services", "Edu.Spring_Core.Dependency_Injection.Printers"})
public class AppConfig {

}