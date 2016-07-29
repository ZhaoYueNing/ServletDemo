package com.buynow.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/requestInfoServlet")
public class DemoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> headerNames = request.getHeaderNames();
		PrintWriter writer = response.getWriter();
		//获取头信息
		while(headerNames.hasMoreElements()){
			String name = headerNames.nextElement();
			String data = request.getHeader(name);
			String out = name+": "+data;
			System.out.println(out);
			writer.println(name+": "+data);
		}
		//cookie
		for (Cookie cookie : request.getCookies()) {
			String name = cookie.getName();
			String value = cookie.getValue();
			System.out.println(name+": "+value);
		}
		//port & ip
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		String remotePort = request.getRemotePort()+"";
		String remoteUser = request.getRemoteUser();
		String localAddr = request.getLocalAddr();
		String localPort = request.getLocalPort()+"";
		
		System.out.println("port & ip info");
		System.out.println(remoteAddr+","+remoteHost+","+remotePort+","+remoteUser
				+","+localAddr+","+localPort);
		
		writer.flush();
		writer.close();  
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
