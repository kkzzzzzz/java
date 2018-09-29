package aop;

import aop.impl.CacheImpl;
import aop.impl.DateSourceImpl;
import aop.impl.HardCodeImpl;
import aop.impl.NoInterfaceAction;
import aop.proxy.ActionProxy;
import aop.proxy.CGLibDynamicProxy;
import aop.proxy.DynamicProxy;

/**
 * Created with IntelliJ IDEA.
 * Project: test-jar
 * Author: Kevin
 * Date: 16/8/14
 * Time: 上午10:45
 */
public class Client {

    public static void main(String[] args) {
//        System.out.println("=============hardCode=============");
//        hardCode();
//        System.out.println("=============staticProxy=============");
//        staticProxy();
//        System.out.println("=============JDKProxy=============");
//        dynamicProxy();
        System.out.println("=============CGLibProxy=============");
        cglibDynamicProxy();
    }

    private static void hardCode(){
        HardCodeImpl hardCode = new HardCodeImpl();
        hardCode.add("object");
    }

    private static void staticProxy(){
        ActionProxy actionProxy = new ActionProxy(new DateSourceImpl());
        System.out.println("代理对象：" + actionProxy.getClass());
        actionProxy.add("object");
        actionProxy.setAction(new CacheImpl());
        actionProxy.add("object");
    }

    private static void dynamicProxy(){
        DynamicProxy dynamicProxy = new DynamicProxy(new DateSourceImpl());
        /**
         * here must return a interface
         * because the Proxy will create a class according the interface
         * this class is the brother of {#code DateSourceImpl}
         * they can not transform
         */
        Action proxy = dynamicProxy.getProxy();
		System.out.println("代理对象：" + proxy.getClass());
        proxy.add("object");
        dynamicProxy.setTarget(new NoInterfaceAction());
        System.out.println("代理对象：" + proxy.getClass());
        proxy.add("object");
    }

    private static void cglibDynamicProxy(){
        CacheImpl cacheImpl = CGLibDynamicProxy.getInstance().getProxy(CacheImpl.class);
        System.out.println("代理对象：" + cacheImpl.getClass());
        cacheImpl.add("object");
        DateSourceImpl dateSourceImpl = CGLibDynamicProxy.getInstance().getProxy(DateSourceImpl.class);
        System.out.println("代理对象：" + dateSourceImpl.getClass());
        dateSourceImpl.add("object");
    }
}
