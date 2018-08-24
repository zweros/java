package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.ShoppingCart;

public class DropFromCart   extends  HttpServlet{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	    //接受前台需要被从购物车中移出的书本的ID
	    long  id  = Long.parseLong(req.getParameter("id"));
	    //从购物车中删除本次的产品
	    HttpSession  session = req.getSession();
	    ShoppingCart   cart =(ShoppingCart) session.getAttribute("cart");
        cart.dropLine(id);
        session.setAttribute("cart", cart);
        
       resp.sendRedirect("shopCart.jsp");
  }
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	      this.doGet(req, resp);
	}
}
