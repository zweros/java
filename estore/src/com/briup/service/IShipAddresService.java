package com.briup.service;

import java.util.List;

import com.briup.bean.ShipAddress;
import com.briup.common.exception.OrderServiceException;

public interface IShipAddresService {
	public ShipAddress getShipAdresById(Long id) throws OrderServiceException;
	public List<ShipAddress> getAllAdres(Long cid) throws OrderServiceException;
}
