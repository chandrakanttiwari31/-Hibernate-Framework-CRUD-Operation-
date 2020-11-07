package com.book.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.book.pojo.Book;
import com.book.utility.DbConnection;

public class BookDaoImpl implements BookDao {

	
	 
	Session session;
	
	@Override
	public boolean addbook(Book book) {
		session=DbConnection.getSession();
		Transaction tr=session.beginTransaction();
		int i = (int)session.save(book);
		tr.commit();
		session.close();
		 if(i>0)
		 {
			 
			 return true;
		 }
		return false;
	}

	@Override
	public boolean updatebook(Book book) {
		session=DbConnection.getSession();
		Transaction tr=session.beginTransaction();
		session.update(book);
		tr.commit();
		session.close();
		
		return true;
	}

	@Override
	public boolean deletebook(Book book) {
		session=DbConnection.getSession();
		Transaction tr=session.beginTransaction();
		session.delete(book);
		
		tr.commit();
		session.close();
		
		return true;
	}

	@Override
	public Book getbook(int id) {
	
		session=DbConnection.getSession();
		Transaction tr=session.beginTransaction();
		Book book=session.get(Book.class, id);
		
		tr.commit();
		session.close();
        return book;
	}

	@Override
	public List<Book> getAllBook() {
		session=DbConnection.getSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from Book");
		List<Book> list=query.list();
		tr.commit();
		session.close();
		return list;
		
       
	}

}
