package edu.mum.ea.bookstore.controller;

import edu.mum.ea.bookstore.domain.Book;
import java.util.List;


public interface IBookDao {

	public abstract List<Book> getAll();

	public abstract void add(Book book);

	public abstract Book get(int id);

	public abstract void update(int bookId, Book book);

	public abstract void delete(int bookId);

}