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
		//��ʼ�����ݿ�����
		System.out.println("FirstServlet##init..");
		//ͳ�Ʒ��ʴ���
		getServletContext().setAttribute("count", 0);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		System.out.println("FirstServlet##����get����3");
		
		ServletConfig config = getServletConfig();
		String param_config = config.getInitParameter("param_info");
	
		String param_context = config.getServletContext().getInitParameter("param_context");

		
		out.println("���ʴ���"+getAccessCount());
		out.println(param_config);
		out.println(param_context);
		out.flush();
		out.close();
		
		
		
		
		
	}
	private int getAccessCount(){
		//ͳ����վ���ʴ���
		ServletContext context = getServletContext();
		int count = (Integer) context.getAttribute("count");
		count++;
		context.setAttribute("count", count);
		return count;
	}
}

