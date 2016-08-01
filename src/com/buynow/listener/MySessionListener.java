package com.buynow.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
	//统计在线人数
	int aliveCounter=0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// 会话被创建
		System.out.println("##会话被创建");
		
		aliveCounter++;
//		se.getSession().getServletContext().setAttribute("ALIVE_COUNTER",aliveCounter);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// 会话被销毁
		System.out.println("##会话被销毁");
		aliveCounter--;
//		se.getSession().getServletContext().setAttribute("ALIVE_COUNTER",aliveCounter);
	}

}
