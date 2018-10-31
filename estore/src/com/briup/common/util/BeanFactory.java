package com.briup.common.util;

import java.io.IOException;
import java.util.Properties;


public class BeanFactory {
	public static final String 
		CUSTOMER_SERVICE="customerService";
	public static final String
		BOOK_SERVICE = "bookService";
	public static final String
		Order_SERVICE = "orderService";
	public static final String SHIPADRES_SERVICE = "shipAdresService";
	private static Properties prop = new Properties();
	static{
		try {
			prop.load(BeanFactory.class
				.getResourceAsStream("beanName.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("初始化beanName异常！");
		}
	}
	public static Object getBean(String name) 
	   
		{
		Object  o  = null;
		String clsName = prop.getProperty(name);
		try {
			 o= Class.forName(clsName).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  o;
		
		
	}
}
