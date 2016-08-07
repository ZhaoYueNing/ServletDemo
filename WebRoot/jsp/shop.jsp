<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.buynow.util.MysqlHelper"%>
<%@page import="com.buynow.servlet.ShowAliveCounterServlet"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Shop</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  	//从数据库读取商品集合
  	MysqlHelper helper = new MysqlHelper("root", "20080808", "127.0.0.1",3306,"buynow");
	Connection conn = helper.getConnection();
	Statement statement = conn.createStatement();
	ResultSet set = statement.executeQuery("select * from commodity");
   %>
  <body>
    <h1>Shop</h1> <br><hr>
    <form action="/servletdemo/shop.do" method="post">
    	<table border="2">
    		<tr>
    			<th>加入购物车</th>
    			<th>商品</th>
    			<th>单价</th>
    			<th>数量</th>    		
    		</tr>
    		<%
    			while(set.next()){
    				String name = set.getString("name");
    				int price = set.getInt("price");
    				int id = set.getInt("id");
    		 %>
    		<tr>
    			<td><input type="checkbox" name="shopCar" value="<%=id%>"></td>
    			<td><%=name%></td>
    			<td><%=price%></td>
    			<td><input type="text" name="amount_<%=id%>"/></td>
    		</tr>
    		<%
    		}
    		 %>
    	</table>
    	<hr>
    	<input type="submit" value="结算购买" >
    </form>
    
  </body>
</html>
