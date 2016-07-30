package com.zhao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//ContextServlet被创建时调用
		System.out.println("##ContextServlet被创建");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//ContextServlet被销毁时调用
		System.out.println("##ContextServlet被销毁");
	}

}
