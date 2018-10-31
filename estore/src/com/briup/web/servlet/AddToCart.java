package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Book;
import com.briup.bean.OrderLine;
import com.briup.bean.ShoppingCart;
import com.briup.common.exception.ServiceException;
import com.briup.service.IBookService;
import com.briup.service.impl.IBookServiceImpl;

public class AddToCart  extends HttpServlet{
IBookService   service  =new  IBookServiceImpl();	
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	  //数量
	    int  num = Integer.parseInt(req.getParameter("num"));
	   //商品的ID 
	    long id  = Long.parseLong(req.getParameter("id"));
	    //根据商品的ID 获取商品详细信息
	    try {
	    	//如果添加到购物车的这本在数据库中存在
			Book  book =service.findBookById(id);
			//将书籍以及本次的数量添加到购物车中
			HttpSession session  = req.getSession();
			//获取购物车
			ShoppingCart  cart =(ShoppingCart) session.getAttribute("cart");
			OrderLine  order  = new OrderLine();
			order.setNum(num);
			order.setBook(book);
			cart.addLine(order);
			
			//测试 商品有没有添加
			for(OrderLine  line  :cart.getOrderlines()){
				System.out.println(line.getBook()+"---"+line.getNum());
			}
			
			
			session.setAttribute("cart", cart);
			//提示用户购买成功
			req.setAttribute("msg", "购买成功");
			//跳转到index.jsp页面继续购买
			req.getRequestDispatcher("../index.jsp").forward(req, resp);
		} catch (ServiceException e) {
			//如果这本书在数据库中没有查找到相应的记录
			req.setAttribute("msg", "该本书已经下架，请重新选购");
			req.getRequestDispatcher("../index.jsp").forward(req, resp);
		}
	    
}
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  this.doGet(req, resp);
		  
	}
}
