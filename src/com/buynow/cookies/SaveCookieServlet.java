package com.buynow.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/savecookie")
public class SaveCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("gbk");
		response.getWriter().println("保存cookie");
		Cookie cookie= new Cookie("username","buynow");
		//保存时间一个小时
		cookie.setMaxAge(60*60);
		//添加cookie
		response.addCookie(cookie);
	}

}
