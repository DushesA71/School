package Edu.Spring_Core.Bean_Scope;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Getter
@Component
@Scope("prototype")
public class TaskContext {
    String id;

    public TaskContext(){
        this.id = UUID.randomUUID().toString();;
    }
}
