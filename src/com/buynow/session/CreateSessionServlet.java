package com.buynow.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/createsession")
public class CreateSessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("gbk");
		
		//创建会话
		HttpSession session= request.getSession();
		if(session.isNew()){
			response.getWriter().println("创建会话成功");
		}else{
			response.getWriter().println("使用之前的会话");
			String id = session.getId();
			long createdTime = session.getCreationTime();
			long lastAccessedTime = session.getLastAccessedTime();
			response.getWriter().println("id:"+id);
			response.getWriter().println("createdTime:"+createdTime);
			response.getWriter().println("lastAccessedTime:"+lastAccessedTime);
		}
		
	}

}
