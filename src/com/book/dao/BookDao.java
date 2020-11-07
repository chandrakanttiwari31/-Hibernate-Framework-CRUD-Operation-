package com.book.dao;

import java.util.List;

import com.book.pojo.Book;

public interface BookDao {
	boolean addbook(Book book);
	boolean updatebook(Book book);
	boolean deletebook(Book book);
	Book  getbook(int id);
	List<Book> getAllBook();

}
