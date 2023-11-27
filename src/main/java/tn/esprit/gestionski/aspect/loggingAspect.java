package tn.esprit.gestionski.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class loggingAspect {
    @After("execution(* tn.esprit.gestionski.services.*.add*(..))")
    public void logmethodeEntry(JoinPoint joinPoint){
        String name=joinPoint.getSignature().getName();
        log.info("sucess",name);
    }
}
