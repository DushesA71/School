package Edu.Spring_Core.Bean_Scope;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.ObjectProvider;

@Component
public class JobRunner {

    private final ObjectProvider<TaskContext> taskContextProvider;
    private final TaskContext context;

    public JobRunner(TaskContext context, ObjectProvider<TaskContext> taskContextProvider){
        this.context = context;
        this.taskContextProvider = taskContextProvider;
    }

    public void runOnce(){
        System.out.println(context.getId());
    }

    public void runOnce2(){
        TaskContext context = taskContextProvider.getObject();
        System.out.println(context.getId());
    }
}
