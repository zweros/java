package com.briup.common.util;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnection {
	private  static String  driver;
	private  static String url;
	private  static String user;
	private  static String pass;
	private  static Properties prop = new Properties();
   static{
	try {
		InputStream ins  =
				GetConnection.class.getResourceAsStream("db.properties");
		System.out.println(ins);
		prop.load(ins);
	
		url=prop.getProperty("driverUrl");

		driver = prop.getProperty("driverName");
		user=prop.getProperty("username");
		pass = prop.getProperty("password");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
 
   public  static   Connection  getConnection(){
	   Connection  conn  =null;
	   try {
		  
		   Class.forName(driver);
		   conn= DriverManager.getConnection(url, user,pass);
	   } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	return conn;
	  
   }
 
}
