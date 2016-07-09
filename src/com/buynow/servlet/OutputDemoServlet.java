package com.buynow.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutputDemoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		output(response);
	}

	private void output(HttpServletResponse resp) throws IOException {
		OutputStream os = resp.getOutputStream();
		//输出中文
		resp.setHeader("Content-Type", "text/html ; charset=UTF-8");
		os.write("你好".getBytes("UTF-8"));
		os.flush();
		os.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
