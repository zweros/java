package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Book;
import com.briup.common.exception.ServiceException;
import com.briup.service.IBookService;
import com.briup.service.impl.IBookServiceImpl;

public class ShowViewBook  extends  HttpServlet{
//构建一个service对象
	IBookService  service  = new IBookServiceImpl();
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	//获取前台传递过来的书本的id然后交给service
	  String id = req.getParameter("id");
	  long  book_id  = Long.parseLong(id);
	//由service 调用 dao 层数据库的方法进行查询
	  try {
		Book book =service.findBookById(book_id);
		req.setAttribute("book", book);
		//携带该本书的信息跳转至viewBook.jsp页面进行书本的显示
		req.getRequestDispatcher("viewBook.jsp").forward(req, resp);
	} catch (ServiceException e) {
		  //如果书本信息获取失败，返回首页并且告诉用户为什么返回首页
		 req.setAttribute("msg", e.getMessage());
		 req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 this.doPost(req, resp);
	}
}
