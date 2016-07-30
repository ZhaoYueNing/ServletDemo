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
		// �����̳߳�
		ThreadPoolExecutor executor = new ThreadPoolExecutor(100,200, 50000L, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(100));
		System.out.println("##�̳߳ر�����");
		//���̳߳ط���������
		sce.getServletContext().setAttribute("executor", executor);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//�ر��̳߳�
		//��ȡ�̳߳�
		ThreadPoolExecutor executor = (ThreadPoolExecutor) sce.
				getServletContext().getAttribute("executor");
		executor.shutdown();
		System.out.println("##�̳߳ر��ر�");
	}

}
