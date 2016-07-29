package com.buynow.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class StreamTools {
	
	public static void in2out(InputStream in , OutputStream out) throws IOException{
		byte[] buf = new byte[1024];
		int len=0;
		while((len = in.read(buf))>0){
			out.write(buf,0,len);
		}
		
	}
	
	public static void in2out(InputStream in,PrintWriter out) throws IOException{
		byte[] buf = new byte[1024];
		int len=0;
		while((len = in.read(buf))>0){
			String str = new String(buf,0,len);
			out.write(str);
		}
	}
}
