package com.buynow.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buynow.domain.Commodity;
import com.buynow.util.MysqlHelper;
@WebServlet("/shop.do")
public class ShopServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<Commodity, Integer> commodityMap = new HashMap<Commodity, Integer>();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		/**
		 *  <td><input type="checkbox" name="isShop" value="<%=name%>"></td>
			<td><%=name%></td>
    		<td><%=price%></td>
    		<td><input type="text" name="amount_<%=name%>"/></td>
		 */
		//数据库
		Statement statement = null ;
		Connection conn =null;
		
		try {
			MysqlHelper helper = new MysqlHelper("root", "20080808", "buynow");
			conn = helper.getConnection();
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取购买信息
		String[] shopCar = request.getParameterValues("shopCar");
		for (String str_id : shopCar) {
			//获取对应id 的购买量
			int id = Integer.parseInt(str_id);
			String str_amount = request.getParameter("amount_"+str_id);
			int amount = Integer.parseInt(str_amount);
			try {
				ResultSet set = statement.executeQuery("select * from commodity where id="+id);
				set.next();
				int price = set.getInt("price");
				String name = set.getString("name");
				Commodity commodity = new Commodity();
				commodity.setId(id);
				commodity.setName(name);
				commodity.setPrice(price);
				commodityMap.put(commodity, amount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//将商品购买信息 放入会话参数中
		request.getSession().setAttribute("SHOP_INFO", commodityMap);
		//跳转到结算页面
		response.sendRedirect("/servletdemo/jsp/squareaccounts.jsp");
		try {
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

}
