package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.common.exception.CustomerServiceException;
import com.briup.service.ICustomerService;
import com.briup.service.impl.ICustomerServiceImpl;

public class RegisterServlet extends  HttpServlet {
	//构建service 对象
	ICustomerService  service  = new ICustomerServiceImpl();
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	//获取前台用户注册的信息
	   String name  =req.getParameter("name");
	   String password  =req.getParameter("password");
	   String zip  =req.getParameter("zip");
	   String address  =req.getParameter("address");
	   String telephone  =req.getParameter("telephone");
	   String email  =req.getParameter("email");
	   //将前台数据封装成对象 在传递给service做业务逻辑判断
	   Customer  cus   = 
			   new Customer(name, password, zip, address, telephone, email);
	   //将数据 进行业务逻辑判断后--> 保存到数据库
	   try {
		service.register(cus);
		//try 代表数据正常注册成功跳转至登录页面 服务器外部跳转
		resp.sendRedirect("login.jsp");
	} catch (CustomerServiceException e) {
	   //代表数据注册失败 需要用户从新注册  跳转到注册页面 并且需要告诉用户失败的原因
	     req.setAttribute("error", e.getMessage());
		req.getRequestDispatcher("register.jsp").forward(req, resp);
	}
}
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
