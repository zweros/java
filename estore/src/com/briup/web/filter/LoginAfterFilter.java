package com.briup.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;

public class LoginAfterFilter implements  Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
//http://127.0.0.1:8888/estore/loginAfter/login.jsp
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		    //判断当前有没有用户登录如果登录了方形
		   //获取HttpSession
		    HttpServletRequest  req  = (HttpServletRequest) arg0;
		    HttpSession session =req.getSession();
		    Customer  cus =(Customer) session.getAttribute("cus");
		   //否则回到login.jsp先让用户登录
		    if(cus==null){
		    	//提示用户先登录再操作
		    	req.setAttribute("msg", "请先登录");
		    	System.out.println(req+"------------");
		    	req.getRequestDispatcher("../login.jsp").forward(req, resp);
		    }else{
		    	 chain.doFilter(req, resp);
		    }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
