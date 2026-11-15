package Edu.Spring_Core.Bean_Lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class OperationContext {
    public OperationContext(){
        System.out.println("Залогировал " + this.getClass().getName());
    }
    @PostConstruct
    void init(){
        System.out.println("Заинитил " + this.getClass().getName());
    }
    @PreDestroy
    void shutdown(){
        System.out.println("Зашатдаунил " + this.getClass().getName());
    }

}
