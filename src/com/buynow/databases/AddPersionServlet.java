package com.buynow.databases;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addpersion.do")
public class AddPersionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = request.getServletContext();
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String sqlUrl = context.getInitParameter("SQL_URL"); 
		String mysqlInit = context.getInitParameter("MYSQL_INIT");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int sex = Integer.parseInt(request.getParameter("sex"));
		String country = request.getParameter("country");
		
		try {
			Class.forName(mysqlInit);
			Connection conn = DriverManager.getConnection(sqlUrl, "root", "20080808");
			Statement statement = conn.createStatement();
			String insert = "INSERT INTO `persion`(name,age,sex,country) VALUES ('"+name+"','"+age+"','"+sex+"','"+country+"');";
			statement.executeUpdate(insert);
			statement.close();
			conn.close();
			out.println("Ìí¼Ó³É¹¦£¡");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
