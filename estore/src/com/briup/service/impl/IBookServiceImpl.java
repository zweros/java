package com.briup.service.impl;

import java.util.Map;

import com.briup.bean.Book;
import com.briup.common.exception.DaoException;
import com.briup.common.exception.ServiceException;
import com.briup.dao.IBookDao;
import com.briup.dao.impl.IBookDaoImpl;
import com.briup.service.IBookService;

public class IBookServiceImpl  implements IBookService{
    IBookDao  dao  = new IBookDaoImpl();
	@Override
	public Map<Long, Book> listAllBook() throws Exception {
		//获取全部的书本信息
		Map<Long, Book> map =dao.getAllBooks();
		return map;
	}

	@Override
	public Book findBookById(long id) throws ServiceException {
		//根据id查找某一本书的详细信息
		Book  book=null;
		try {
		 book=	dao.getBookById(id);
		if(book ==null){
			 throw new ServiceException("该本书已经下架，请重新选购");
		}
		} catch (DaoException e) {
			throw  new ServiceException(e.getMessage());
		}
		return book;
	}

}
