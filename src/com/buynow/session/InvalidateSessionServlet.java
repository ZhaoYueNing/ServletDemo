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
		
		//结束本次会话
		HttpSession session = request.getSession(false);
		if(session==null){
			writer.println("无会话对象");
		}else{
			//会话对象被结束
			session.invalidate();
			writer.println("会话成功结束 id："+session.getId());
		}
		
	}

}
