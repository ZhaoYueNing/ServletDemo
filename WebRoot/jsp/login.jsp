<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 
 <%!String username=null;
  %> 
  <%
  	Cookie[] cookies = request.getCookies();
  	for(int i=0;i<cookies.length;i++){
  		Cookie cookie = cookies[i];
  		if(cookie.getName().equals("login_username")){
  			username=cookie.getValue();		
  		}
  	}
   %>
    登录
    <hr><br>
    	<form action="login.do" method="post">
    		<%
    			if(username!=null){
    		 %>
    		用户名：<input type="text" name="username" value="<%=username%>"/><br>
    		<%
    		}else{
    		 %>
    		 用户名：<input type="text" name="username" /><br>
    		 <%} %>
    		密&nbsp;码：<input type="password" name="password"/><br>
    		<input type="submit" value="submit">
    	</form>
    	<hr>
     <br>
  </body>
</html>
