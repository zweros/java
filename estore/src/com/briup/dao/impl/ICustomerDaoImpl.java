package com.briup.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.bean.Customer;
import com.briup.common.exception.CustomerDaoException;
import com.briup.common.util.GetConnection;
import com.briup.dao.ICustomerDao;

public class ICustomerDaoImpl  implements  ICustomerDao{

	@Override
	public void register(Customer cus) throws CustomerDaoException {
         //注册		
		
		try {
			Connection  conn  = GetConnection.getConnection();
			String sql  ="insert into  tbl_customer(address,email,name,password,telephone,zip) values(?,?,?,?,?,?)";
			PreparedStatement  ps  = conn.prepareStatement(sql);
			ps.setString(1, cus.getAddress());
			ps.setString(2, cus.getEmail());
			ps.setString(3, cus.getName());
			ps.setString(4, cus.getPassword());
			ps.setString(5, cus.getTelephone());
			ps.setString(6, cus.getZip());
			//数据执行收sql语句
			ps.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			 e.getStackTrace();
			 throw  new CustomerDaoException("数据库异常");
		}
		
	}

	@Override
	public void deleteUser(long id) throws CustomerDaoException {
		//通过用户的ID删除一个用户
	}

	@Override
	public void update(Customer cus) throws CustomerDaoException {
		 //跟新一个用户信息
		
	}

	@Override
	public Customer findUserByName(String name) throws CustomerDaoException {
	//通过用户名查找用户的信息
   //获取Connection 对象
		  Customer cus =null;
		try {
			Connection  conn  = GetConnection.getConnection(); 
			String  sql ="select * from  tbl_customer where name ='"+name+"'";
			Statement  st  =conn.createStatement();
			ResultSet  set  = st.executeQuery(sql);
			while(set.next()){
			  long  id  = set.getLong("customer_id");
			  String address = set.getString("address");
			  String  email = set.getString("email");
			  String username  = set.getString("name");
			  String pass  = set.getString("password");
			  String tel  = set.getString("telephone");
			  String zip  = set.getString("zip");
			 cus= 
			    new Customer(id, username, pass, zip, address, tel, email);	
			}
		} catch (SQLException e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
		   throw  new CustomerDaoException("数据库异常");
		}
		return cus;
	}

}
