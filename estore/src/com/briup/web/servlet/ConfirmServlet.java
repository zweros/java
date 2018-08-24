package com.briup.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.bean.ShipAddress;
import com.briup.bean.ShoppingCart;
import com.briup.common.exception.OrderServiceException;
import com.briup.service.IOrderService;
import com.briup.service.impl.IOrderServiceImpl;

public class ConfirmServlet extends HttpServlet{
//构建service层的对象
IOrderService  service  = new IOrderServiceImpl();	
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	   String name  = req.getParameter("name");
	   String address=req.getParameter("address");
	   String tel  = req.getParameter("tel");
	   //将当前地址封装成对象
	   ShipAddress  add  = new ShipAddress(name, address, tel);
	   HttpSession  session  = req.getSession();
	   //获取当前提交订单的用户信息
       Customer  cus =(Customer) session.getAttribute("cus");	   
      //获取购物车相关信息
       ShoppingCart  cart =(ShoppingCart) session.getAttribute("cart");
       //将订单保存至数据库
       OrderForm  orderForm = new OrderForm();
       //本次订单中全部的商品
       orderForm.setLines(cart.getOrderlines());
       //本次订单的所有者
       orderForm.setCus(cus);
       //本比订单花费了多少钱
       orderForm.setCost(cart.getCost());
       //本次订单的配送地
       orderForm.setSadres(add);
       //本次订单的下单日期
       orderForm.setOrderdate(new Date());
       try {
		service.saveOrder(orderForm);
		//订单保存成功后清空购物车并重新购物
		cart.removeAll();
		session.setAttribute("cart", cart);
		session.setAttribute("cus", cus);
		req.setAttribute("msg", "购买成功");
		req.getRequestDispatcher("confirmSuc.jsp").forward(req, resp);
	} catch (OrderServiceException e) {
		req.setAttribute("msg", "购买失败");
		req.getRequestDispatcher("confirmSuc.jsp").forward(req, resp);
	}
       
  }
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 this.doGet(req, resp);
	}
}
