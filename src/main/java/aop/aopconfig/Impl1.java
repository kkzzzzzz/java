package aop.aopconfig;import org.springframework.stereotype.Component;/** * Created with IntelliJ IDEA. * Project: test-jar * Author: Kevin * Date: 2018/9/29 * Time: 下午7:21 */@Componentpublic class Impl1 implements AopConfigInterface {	@Override	public <T> void add(T t) {		System.out.println("impl1 add: " + t);	}	@Override	public void print(String s) {		System.out.println("impl1 print: " + s);	}}