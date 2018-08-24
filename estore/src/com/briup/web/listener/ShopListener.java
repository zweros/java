package com.briup.web.listener;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.briup.bean.Book;
import com.briup.service.IBookService;
import com.briup.service.impl.IBookServiceImpl;
//监听到服务器的启动 与服务器的关闭
public class ShopListener implements ServletContextListener {
    IBookService  serive  = new IBookServiceImpl();
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
       System.out.println("服务器已经开启-----"); 	
       //从数据库中获取书本信息 并且将这些信息保存到服务器上下文环境对象中
	    try {
			Map<Long, Book> map=serive.listAllBook();
			//获取上下文环境对象
			ServletContext  context =event.getServletContext();
			//将map保存至上下文环境
			context.setAttribute("books", map);
			System.out.println(map.size());
		} catch (Exception e) {
			
		}
	}

}
