<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page info="sql connect test" errorPage="/html/errorPage.html"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jdbcdemo.jsp' starting page</title>
    
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
    数据库连接测试 <br>
    <%
    	Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/buynow","root","20080808");
		Statement statement = conn.createStatement();
		String sql = "SELECT * FROM persion";
		ResultSet result = statement.executeQuery(sql);
			%>
				<table bgcolor="#9999dd" border="2" >
				<tr>
					<th><%="id" %><th>
					<th><%="name" %><th>
					<th><%="age" %><th>
					<th><%="sex" %><th>
					
				</tr>
			<%				
				
		while(result.next()){
			String name = result.getString("name");
			int age = result.getInt("age");
			int sex = result.getInt("sex");
			int id = result.getInt("id");
			%>
				<tr>
					<td><%=id %><td>
					<td><%=name %><td>
					<td><%=age %><td>
					<td><%=sex %><td>
					
				</tr>
			<%			
		}
		%>
				</table>
			<% 
		result.close();
		statement.close();
		conn.close();
     %>
  </body>
</html>
