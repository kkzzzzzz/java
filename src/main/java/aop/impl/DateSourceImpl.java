package aop.impl;

import aop.Action;
import aop.annotion.Log;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Project: test-jar
 * Author: Kevin
 * Date: 16/8/14
 * Time: 上午10:32
 */
@Component
public class DateSourceImpl implements Action {

    @Override
    @Log
    public <T> void add(T t) {
        before();
		System.out.println("add" + t + "to db");
        after();
    }

    private void before(){
        System.out.println("before");
    }

    private void after(){
        System.out.println("after");
    }

}
