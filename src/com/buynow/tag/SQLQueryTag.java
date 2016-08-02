package com.buynow.tag;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/**
 * 将数据库的内容以表格的形式全部显示出来
 * @author Zhao
 *
 */
public class SQLQueryTag extends SimpleTagSupport{
	private String sql_username;
	private String sql_password;
	private String sql_connurl;
	private String sql_tableName;
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<table border='2'>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(sql_connurl,sql_username,sql_password);
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery("SELECT * FROM "+sql_tableName);
			ResultSetMetaData rsmd = set.getMetaData();
			int cloumnCount = rsmd.getColumnCount();
			//表头显示
			out.print("<tr>");
			for(int i=1;i<=cloumnCount;i++){
				String cloumnName = rsmd.getColumnName(i);
				out.print("<th>");
				out.print(cloumnName );
				out.print("</th>");
				out.println();
			}
			out.print("</tr>");
			while(set.next()){
				out.println("<tr>");
				for(int i=1;i<=cloumnCount;i++){
					String value = set.getString(i);
					out.print("<td>");
					out.print(value);
					out.println("</td>");
				}
				out.println("</tr>");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.print("<table border='2'/>");
	}
	//get & set
	public String getSql_username() {
		return sql_username;
	}

	public void setSql_username(String sql_username) {
		this.sql_username = sql_username;
	}

	public String getSql_password() {
		return sql_password;
	}

	public void setSql_password(String sql_password) {
		this.sql_password = sql_password;
	}

	public String getSql_connurl() {
		return sql_connurl;
	}

	public void setSql_connurl(String sql_connurl) {
		this.sql_connurl = sql_connurl;
	}

	public String getSql_tableName() {
		return sql_tableName;
	}

	public void setSql_tableName(String sql_tableName) {
		this.sql_tableName = sql_tableName;
	}
	
	

}
 