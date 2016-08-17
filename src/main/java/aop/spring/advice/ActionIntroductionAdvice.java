package aop.spring.advice;

import aop.spring.Alarm;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Project: test-jar
 * Author: Kevin
 * Date: 16/8/15
 * Time: 下午4:00
 */
@Component
public class ActionIntroductionAdvice extends DelegatingIntroductionInterceptor implements Alarm {

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }

    @Override
    public void sendMail() {
        System.out.println("send mail");
    }
}
