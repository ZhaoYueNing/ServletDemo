package com.buynow.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/removecookie")
public class RemoveCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("gbk");
	
		//查看cookie
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().contains("username")){
				//设置为0及浏览器将会自动删除
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
				resp.getWriter().println(cookie.getValue()+"被删除");
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
