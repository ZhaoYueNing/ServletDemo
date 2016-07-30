package com.zhao.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class MyServletRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		//请求被销毁
		System.out.println("##请求被销毁 "+sre.getServletRequest().getRemoteAddr());
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		//请求创建
		System.out.println("##请求被创建 "+sre.getServletRequest().getRemoteAddr());
	}

}
