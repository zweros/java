package com.briup.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.bean.OrderLine;
import com.briup.common.exception.OrderServiceException;
import com.briup.common.util.GetConnection;
import com.briup.dao.IOrderDao;
public class IOrderDaoImpl  implements IOrderDao{

	@Override
	public void saveOrder(OrderForm order) throws OrderServiceException {
        try {
        	Customer  cust = order.getCus();
        	Connection  conn  = GetConnection.getConnection();
        	//保存订单的提交地址
        	String sql ="insert into tbl_shipaddress(adres,phoneNumber,shipuname,customer_id) values(?,?,?,?)";
			PreparedStatement  ps  =conn.prepareStatement(sql);
		    ps.setString(1, order.getSadres().getAdres());
		    ps.setString(2, order.getSadres().getPhone());
		    ps.setString(3, order.getSadres().getShipuname());
		    ps.setLong(4, cust.getId());
		    ps.execute();
		    ps.close();
		    //获取提交地址的ID
		    
		    sql  ="select shipaddress_id from tbl_shipaddress where adres=? ";
		    ps=conn.prepareStatement(sql);
		    ps.setString(1,order.getSadres().getAdres() );
		    ResultSet  set  =ps.executeQuery();
		    long shipAdd_id =0;
		    while(set.next()){
		    	shipAdd_id=set.getLong(1);
		    	break;
		    }
		    ps.close();
		    
		    //保存订单本身
		    String sql1  ="insert into  tbl_orderform(cost,orderDate,customer_id,shipaddress_id) values(?,?,?,?)";
		    ps =conn.prepareStatement(sql1);
		    ps.setDouble(1, order.getCost());
		    ps.setDate(2, new java.sql.Date(order.getOrderdate().getTime()));
		    ps.setLong(3, cust.getId());
		    ps.setLong(4,shipAdd_id);
		    ps.execute();
		    sql1="select orderform_id from tbl_orderform where orderDate=?";
		    ps = conn.prepareStatement(sql1);
		    ps.setDate(1,new  java.sql.Date(order.getOrderdate().getTime()));
		    ResultSet  set1  =ps.executeQuery();
		    long orderform_id =0;
		    while(set1.next()){
		    	orderform_id=set1.getLong("orderform_id");
		    }
		    //保存订单细节
		    String sql2 ="insert into tbl_orderline(num,book_id,orderform_id) values(?,?,?)"; 
		    ps =conn.prepareStatement(sql2);
		    for(OrderLine  line  : order.getLines()){
		    	ps.setInt(1, line.getNum());
		    	ps.setLong(2, line.getBook().getId());
		    	ps.setLong(3, orderform_id);
		    	ps.execute();
		    }
        } 
        catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delOrder(Long orderid) throws OrderServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Long, OrderForm> listAllOrder(Long customerid)
			throws OrderServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderForm findOrderById(Long orderid) throws OrderServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
