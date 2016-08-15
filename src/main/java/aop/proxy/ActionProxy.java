package aop.proxy;

import aop.Action;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Project: test-jar
 * Author: Kevin
 * this it a proxy for interface action
 * Date: 16/8/14
 * Time: 上午10:36
 */
@Component
public class ActionProxy implements Action {

    private Action action;

    public ActionProxy(Action action){
        this.action = action;
    }

    @Override
    public <T> void add(T t) {
        before();
        action.add(t);
        after();
    }

    private void before(){
        System.out.println("before");
    }

    private void after(){
        System.out.println("after");
    }
}
