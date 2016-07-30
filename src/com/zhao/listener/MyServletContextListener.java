package com.zhao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//ContextServlet������ʱ����
		System.out.println("##ContextServlet������");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//ContextServlet������ʱ����
		System.out.println("##ContextServlet������");
	}

}
