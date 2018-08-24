package com.briup.dao.impl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.briup.bean.Book;
import com.briup.common.exception.DaoException;
import com.briup.common.util.GetConnection;
import com.briup.dao.IBookDao;
public class IBookDaoImpl implements IBookDao {

	@Override
	public Map<Long, Book> getAllBooks() throws Exception {
		//从数据库获取全部的书本信息
	    Connection  conn = GetConnection.getConnection();
	    //获取statement或者PreparedStatement
	    String sql ="select * from tbl_book ";
	    Statement st =conn.createStatement();
	    ResultSet  set =st.executeQuery(sql);
	    Map<Long,Book>  map  = new HashMap<Long, Book>();
	    while(set.next()){
	    	long id  =set.getLong("book_id");
	    	String name  = set.getString("name");
	    	double  price  = set.getDouble("price");
	    	Book  book  = new Book(id,name,price);
	    	map.put(id, book);
	    }
		return map;
	}
	
	@Override
	public Book getBookById(long id) throws DaoException {
		//根据id从数据库中获取书本信息
		Connection  conn  =GetConnection.getConnection();
		String sql ="select * from  tbl_book where book_id ="+id;
		 Book  book =null;
		try {
			Statement st  =conn.createStatement();
			ResultSet  set =st.executeQuery(sql);
			while(set.next()){
				 long book_id  = set.getLong("book_id");
				 String name  = set.getString("name");
				 double  price  = set.getDouble("price");
				 book= new Book(book_id, name, price);
				 
			}
		} catch (SQLException e) {
			  throw  new DaoException("数据库异常");
		}
		return book;
	}
}
