package aop.spring;

import aop.Action;
import aop.impl.PureImpl;
import aop.spring.advice.ActionAfterAdvice;
import aop.spring.advice.ActionAroundAdvice;
import aop.spring.advice.ActionBefroeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created with IntelliJ IDEA.
 * Project: test-jar
 * Author: Kevin
 * Date: 16/8/15
 * Time: 下午2:39
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=============TwoAdvice=============");
        TwoAdvice();
        System.out.println("=============OneAdvice=============");
        OneAdvice();
    }

    private static void TwoAdvice(){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new PureImpl());
        proxyFactory.addAdvice(new ActionBefroeAdvice());
        proxyFactory.addAdvice(new ActionAfterAdvice());
        Action action = (Action) proxyFactory.getProxy();
        action.add("object");
    }

    private static void OneAdvice(){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new PureImpl());
        proxyFactory.addAdvice(new ActionAroundAdvice());
        Action action = (Action) proxyFactory.getProxy();
        action.add("object");
    }

}
