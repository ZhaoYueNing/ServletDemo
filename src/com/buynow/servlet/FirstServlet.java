package com.buynow.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		//初始化数据库链接
		System.out.println("FirstServlet##init..");
		//统计访问次数
		getServletContext().setAttribute("count", 0);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		System.out.println("FirstServlet##访问get方法3");
		
		ServletConfig config = getServletConfig();
		String param_config = config.getInitParameter("param_info");
	
		String param_context = config.getServletContext().getInitParameter("param_context");

		
		out.println("访问次数"+getAccessCount());
		out.println(param_config);
		out.println(param_context);
		out.flush();
		out.close();
		
		
		
		
		
	}
	private int getAccessCount(){
		//统计网站访问次数
		ServletContext context = getServletContext();
		int count = (Integer) context.getAttribute("count");
		count++;
		context.setAttribute("count", count);
		return count;
	}
}

