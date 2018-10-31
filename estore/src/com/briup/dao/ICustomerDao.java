package com.briup.dao;

import com.briup.bean.Customer;
import com.briup.common.exception.CustomerDaoException;

public interface ICustomerDao {

  //用户注册
	public   void   register(Customer cus) throws  CustomerDaoException;
  //用户删除	
	public  void  deleteUser(long id ) throws  CustomerDaoException;
  //更新用户信息
	public  void update(Customer  cus) throws  CustomerDaoException;
  //更新用户信息
	public  Customer findUserByName(String  name) throws  CustomerDaoException ;
}
