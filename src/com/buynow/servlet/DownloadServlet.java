package com.buynow.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userAgent = request.getHeader("User-Agent");
		System.out.println(userAgent);
		
		
 
		//获取context对象
		String path  = getServletContext().getRealPath("/ex_file/demo_file.txt");
		String[] paths = path.split("\\\\");
		System.out.println(paths+" "+paths.length);
		String fileName = paths[paths.length-1];
		if(userAgent.contains("MSIE")){
			fileName = URLEncoder.encode(fileName);
		}
		System.out.println();
		
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		//获取文件的输入流 
		InputStream in = new FileInputStream(path);
		//获取输出流
		OutputStream out = response.getOutputStream();

		//输出访客地址 和 下载文件路劲
		System.out.println(request.getRemoteAddr());
		System.out.println(path);
		
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = in.read(buffer))>0){
			out.write(buffer,0,len);
		}
		
		
		in.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.flush();
		out.close();
	}

}
