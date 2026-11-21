package Edu.Spring_Core.final_task.src.main.Java.user;

import Edu.Spring_Core.final_task.src.main.Java.account.AccountService;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class UserService {
     Map<Integer, User> users = new HashMap<Integer, User>();
     AccountService accountService;
     private static final AtomicInteger Sequence = new AtomicInteger();

     public UserService(AccountService accountService){
          this.accountService = accountService;
     }

     public User CreateUser(String login){
          int i = Sequence.incrementAndGet();
          User newUser = new User(i, login, accountService.createAcc(i));
          users.put(i, newUser);
          return newUser;
     }

     public User findById(Integer id){
          return users.get(id);
     }

     public Collection<User> findAll(){
          return users.values();
     }
}
