package com.buynow.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefreshServlet extends HttpServlet {
	private static int count = 0;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		response.setHeader("refresh", "5;url=/servletdemo/refreshservlet");
		out.println("´ÎÊý:"+count);
		count++;
		out.flush();
		out.close();
	}

}
