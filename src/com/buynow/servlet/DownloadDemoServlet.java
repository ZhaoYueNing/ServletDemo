package com.buynow.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buynow.util.StreamTools;
@WebServlet("/downloaddemo")
public class DownloadDemoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;charset=utf-8");
		
		String downloadFileName = request.getParameter("file");
	
		response.setHeader("Content-Disposition", "attachment;filename="+downloadFileName);
	
		String path = getServletContext().getRealPath("/upload/"+downloadFileName);
		
		FileInputStream in = new FileInputStream(path);
		
//		InputStream in = getServletContext().getResourceAsStream(
//				"/upload/"+downloadFileName);
		OutputStream out = response.getOutputStream();
		StreamTools.in2out(in, out);
		out.flush();
		out.close();
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
