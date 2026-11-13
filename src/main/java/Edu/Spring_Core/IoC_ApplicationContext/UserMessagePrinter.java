package Edu.Spring_Core.IoC_ApplicationContext;

public class UserMessagePrinter {

    UserMessageService userMessageService;

    public UserMessagePrinter(UserMessageService OutUserMessageService){
        this.userMessageService = OutUserMessageService;
    };

    public void printMessage(String name){
        System.out.println(userMessageService.createMessage(name));
    };
}
