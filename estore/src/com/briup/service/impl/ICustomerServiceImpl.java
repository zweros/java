package com.briup.service.impl;

import com.briup.bean.Customer;
import com.briup.common.exception.CustomerDaoException;
import com.briup.common.exception.CustomerServiceException;
import com.briup.dao.ICustomerDao;
import com.briup.dao.impl.ICustomerDaoImpl;
import com.briup.service.ICustomerService;

public class ICustomerServiceImpl implements ICustomerService {
    ICustomerDao  dao  = new ICustomerDaoImpl();
	@Override
	public void register(Customer customer) throws CustomerServiceException {
       //注册用户	用户名不允许重复  所以要求 customer传递过来的名字在数据库中不能存在
		//通过用户名去数据库中查找用户
		try {
			Customer  cust = dao.findUserByName(customer.getName());
		    if(cust==null){
		    	dao.register(customer);
		    }else{
		    	//该用户名在数据库中已经注册
		    	throw  new  CustomerServiceException("该用户名已经存在");
		    }
		} catch (CustomerDaoException e) {
			 throw  new  CustomerServiceException(e.getMessage());
		}
	}

	@Override
	public Customer login(String name, String password)
			throws CustomerServiceException {
		Customer  cus =null;
		  try {
		    //登录  用户名在数据库中存在
			cus =dao.findUserByName(name);
			if(cus!=null){
				 if(! cus.getPassword().equals(password)){
					 throw  new CustomerServiceException("密码错误，请重新输入密码");
				 }
			}else{
				 throw new CustomerServiceException("该用户名没有注册，请您先注册");
			}
		} catch (CustomerDaoException e) {
			  throw  new CustomerServiceException("数据库异常");
		}
		//该用户名对相应密码与输入的密码保持一直
		return cus;
	}

	@Override
	public void update(Customer customer) throws CustomerServiceException {
      //更新用户		
	}

}
