package com.buynow.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��ȡ�û���������
		String username = request.getParameter("username");
		System.out.println("username:"+username);
		String password = request.getParameter("password");
		System.out.println("password:"+password);
		
		//�ж��û���������
		if("admin".equals(username)&&"admin".equals(password)){
			//��¼�ɹ�
			response.getWriter().println("login success");
		}else{
			//��¼ʧ��
			response.setStatus(302);
			response.setHeader("location", "/servletdemo/response/login.html");	
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
