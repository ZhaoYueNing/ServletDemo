package com.buynow.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextAttributeListener implements
		ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		//添加属性时被调用
		System.out.println("##添加属性"+scab.getName()+" :"+scab.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		//属性被删除
		System.out.println("##删除属性"+scab.getName()+" :"+scab.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		//属性被替换
		System.out.println("##替换属性"+scab.getName()+" :"+scab.getValue());
	}

}
