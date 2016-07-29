package com.buynow.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/uploaddemo")
@MultipartConfig
public class UploadDemoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getUploadFile(request,response);
		
	}
	/**
	 * 获取上传文件
	 * @param request
	 * @param response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	private void getUploadFile(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("html/text;charset=utf-8");
		
		String savePath = getServletContext().getRealPath("/upload");
		File file = new File(savePath);
		file.mkdirs();
		Part part = request.getPart("file");
		String fileName = getFileName(part);
		file=new File(file.getAbsolutePath()+File.separator+fileName);
		System.out.println("##filename:"+fileName);
		InputStream in = part.getInputStream();
		PrintWriter out = response.getWriter();
		OutputStream clientOut = response.getOutputStream();
		
		in2out(in,clientOut);
		in2out(in,out);
		
		
		in.close();
		out.flush();
		out.close();
		clientOut.flush();
		clientOut.close();
	}
	
	private void in2out(InputStream in , OutputStream out) throws IOException{
		byte[] buf = new byte[1024];
		int len=0;
		while((len = in.read(buf))>0){
			out.write(buf,0,len);
		}
		
	}
	
	private void in2out(InputStream in,PrintWriter out) throws IOException{
		byte[] buf = new byte[1024];
		int len=0;
		while((len = in.read(buf))>0){
			String str = new String(buf,0,len);
			out.write(str);
		}
	}
	
	//返回文件名
	private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                String filename = content.substring(
                        content.lastIndexOf('\\') + 1).trim().replace("\"", "");
                filename=filename.substring(9);
                return filename;
            }
        }
        return null;
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	


}
