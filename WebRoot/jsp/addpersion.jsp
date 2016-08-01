<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addpersion.jsp' starting page</title>
    
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
  <form method="post" action="addpersion.do">
    添加个人信息到数据库. <br>
    姓名：<br>
    <input type="text" name="name"/>
    <hr>
    性别  :<br/>
    <input name="sex" value="1" type="radio"/>男
    <input name="sex" value="0" type="radio"/>女
    <hr>
    年龄：<br>
    <input type="text" name="age"/>
    <hr>
      国籍:
     <select name="country">
     	<option value="CN">中国</option>
     	<option value="US">美国</option>
     	<option value="JP">日本</option>
     	<option value="EN">英国</option>
     </select> 
     <hr>
     <br>
     <input type="submit" value="添加">
     </form>
  </body>
</html>
