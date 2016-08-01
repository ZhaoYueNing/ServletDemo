package com.buynow.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/invalidatesession")
public class InvalidateSessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("gbk");
		PrintWriter writer = response.getWriter();
		
		//�������λỰ
		HttpSession session = request.getSession(false);
		if(session==null){
			writer.println("�޻Ự����");
		}else{
			//�Ự���󱻽���
			session.invalidate();
			writer.println("�Ự�ɹ����� id��"+session.getId());
		}
		
	}

}
