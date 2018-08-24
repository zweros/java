package com.briup.web.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.briup.bean.Customer;
import com.briup.bean.ShoppingCart;
import com.briup.common.exception.CustomerServiceException;
import com.briup.service.ICustomerService;
import com.briup.service.impl.ICustomerServiceImpl;
public class LoginServlet  extends  HttpServlet{
 ICustomerService  service  = new ICustomerServiceImpl();
	@Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	//接受前台用户需用登录的用户名和密码
	   String name =req.getParameter("name");
	   String pass  =req.getParameter("password");
	 //判断是否可以进行登录  
	   try {
		Customer  cus =service.login(name, pass);
		//如果这个用户允许登录，那么我们需要将这个用户信保存到Session中
		//获取session
		HttpSession  session = req.getSession();
		if(session.getAttribute("cus")==null){
			session.setAttribute("cus",cus);
		}
		//给每个登录成功的用户都准备一个购物车（篮子）
		ShoppingCart  cart  =(ShoppingCart) session.getAttribute("cart");
		
		if(cart==null){
		  cart =new   ShoppingCart();
		  session.setAttribute("cart", cart);
		}
		//登录成功跳转首页
		resp.sendRedirect("index.jsp");
	} catch (CustomerServiceException e) {
		  //登录  失败跳转至登录页面  告诉用户为什么登录失败
		req.setAttribute("error", e.getMessage());
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 this.doGet(req, resp);
	}
}
