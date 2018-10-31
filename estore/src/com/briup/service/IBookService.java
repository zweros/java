package com.briup.service;

import java.util.Map;

import com.briup.bean.Book;
import com.briup.common.exception.OrderServiceException;
import com.briup.common.exception.ServiceException;
public interface IBookService {
	//查找所有书籍
		Map<Long,Book> listAllBook() throws Exception;
	//通过ID查找书本的详细信息
		Book findBookById(long id) throws ServiceException;
}
