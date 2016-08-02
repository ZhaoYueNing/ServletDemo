<%@page import="com.buynow.domain.Commodity"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'squareaccounts.jsp' starting page</title>
    
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
    <h1>结算</h1><hr><br>
    <%
    	//需付款
    	int money = 0;
    	//获取购物信息
    	Map<Commodity,Integer> commodityMap = (Map<Commodity,Integer>)session.getAttribute("SHOP_INFO");
    	if(commodityMap.size()==0){
     %>
     		<b>无购物信息，请重新选购</b>
     <%
     		return ;
     	}
     	%>
     	<table border="2">
     		<tr>
     			<th>商品</th>
     			<th>单价</th>
     			<th>数量</th>
     			<th>小计</th>
     		</tr>	
     	<% 
     	Set<Commodity> set = commodityMap.keySet();
     	for(Commodity c:set){
     			String name = c.getName();
     			int price = c.getPrice();
     			int amount = commodityMap.get(c);
     			int xiaoji = amount*price;
     			money+=xiaoji;
     	%>
      	<tr>
     		<th><%=name%></th>
     		<th><%=price%></th>
     		<th><%=amount%></th>
     		<th><%=xiaoji%></th>
     	</tr>	
     	<%} %>
     	
     	
      </table>
      <b>合计：</b><%=money %>
  </body>
</html>
