package com.buynow.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
	//ͳ����������
	int aliveCounter=0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// �Ự������
		System.out.println("##�Ự������");
		
		aliveCounter++;
//		se.getSession().getServletContext().setAttribute("ALIVE_COUNTER",aliveCounter);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// �Ự������
		System.out.println("##�Ự������");
		aliveCounter--;
//		se.getSession().getServletContext().setAttribute("ALIVE_COUNTER",aliveCounter);
	}

}
