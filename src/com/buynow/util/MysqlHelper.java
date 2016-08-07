package com.buynow.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.derby.iapi.util.ReuseFactory;


public class MysqlHelper {
	private String username;
	private String password;
	private final String MYSQL_INIT = "com.mysql.jdbc.Driver";
	private String  connUrl;
	private int port;
	private Connection conn;
	//jdbc:mysql://127.0.0.1/buynow
	
	public MysqlHelper(String username, String password, String host,
			int port,String databaseName) {
		this.username = username;
		this.password = password;
		this.connUrl = "jdbc:mysql://"+host+":"+port+"/"+databaseName;
		this.port = port;
		try {
			Class.forName(MYSQL_INIT);
			conn=getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public MysqlHelper(String username, String password,String databaseName) {
		this(username,password,"127.0.0.1",3306,databaseName);
	}
	
	public Connection getConnection(){
		try {
			if(this.conn==null||this.conn.isClosed()){
				this.conn = DriverManager.getConnection(connUrl, username, password);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return this.conn;			
		}
	}
	

}
