package Edu.Spring_Core.Spring_AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
    @Component
    class NotNullArgsAspect {

    @Around("@annotation(NotNullArgs)")
    public Object measure(ProceedingJoinPoint pjp, NotNullArgs NotNullArgs) throws Throwable {
        Object[] Args = pjp.getArgs();
        for (int i = 0; i < Args.length; ++i){
            if(Args[i] == null){
                throw new IllegalArgumentException(String.format("buildReport args[%d] is null", i));
            };
        };
        return pjp.proceed();
    }
}