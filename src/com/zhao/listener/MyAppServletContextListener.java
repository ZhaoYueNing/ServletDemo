package com.zhao.listener;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class MyAppServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 创建线程池
		ThreadPoolExecutor executor = new ThreadPoolExecutor(100,200, 50000L, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(100));
		System.out.println("##线程池被创建");
		//将线程池放入属性中
		sce.getServletContext().setAttribute("executor", executor);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//关闭线程池
		//获取线程池
		ThreadPoolExecutor executor = (ThreadPoolExecutor) sce.
				getServletContext().getAttribute("executor");
		executor.shutdown();
		System.out.println("##线程池被关闭");
	}

}
