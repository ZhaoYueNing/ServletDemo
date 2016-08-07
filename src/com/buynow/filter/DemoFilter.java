package com.buynow.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="log"
	,urlPatterns={"/*"})
public class DemoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		System.out.println("##捕获请求："+httpRequest.getRemoteAddr());
		chain.doFilter(httpRequest, response);
		System.out.println("##捕获结束");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
