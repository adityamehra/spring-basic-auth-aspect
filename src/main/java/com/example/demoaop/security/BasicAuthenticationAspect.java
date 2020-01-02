package com.example.demoaop.security;

import com.example.demoaop.error.UnAuthorizedAccessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BasicAuthenticationAspect {

    @Before("@annotation(BasicAuthentication)")
    public void checkAuthToken(JoinPoint proceedingJoinPoint) throws UnAuthorizedAccessException {
        Object[] args = proceedingJoinPoint.getArgs();
        String token = (String) args[0];
        System.out.println(token);
        if (!token.equalsIgnoreCase("Basic YWRtaW46YWRtaW5AMTIzNA==")) {
            throw new UnAuthorizedAccessException();
        }
    }
}
