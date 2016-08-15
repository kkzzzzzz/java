package aop.aspject;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created with IntelliJ IDEA.
 * Project: test-jar
 * Author: Kevin
 * Date: 16/8/14
 * Time: 上午10:41
 */
@Aspect
public class LogAop {

    @Around("@annotation(aop.annotion.Log)")
    public void logImpl(ProceedingJoinPoint invocation) throws Exception{
        System.out.println("do log");
        try {
            invocation.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
