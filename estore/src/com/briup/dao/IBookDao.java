package com.briup.dao;

import java.util.Map;

import com.briup.bean.Book;
import com.briup.common.exception.DaoException;

public interface IBookDao {
  public  Map<Long,Book>  getAllBooks()   throws Exception ;
  public  Book getBookById(long id ) throws DaoException;
}
