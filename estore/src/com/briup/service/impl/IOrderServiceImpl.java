package com.briup.service.impl;

import java.util.Map;

import com.briup.bean.OrderForm;
import com.briup.common.exception.OrderServiceException;
import com.briup.dao.IOrderDao;
import com.briup.dao.impl.IOrderDaoImpl;
import com.briup.service.IOrderService;

public class IOrderServiceImpl implements  IOrderService{
     IOrderDao  dao  = new IOrderDaoImpl();
	@Override
	public void saveOrder(OrderForm order) throws OrderServiceException {
    //保存订单的相关信息		
	  dao.saveOrder(order);
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
