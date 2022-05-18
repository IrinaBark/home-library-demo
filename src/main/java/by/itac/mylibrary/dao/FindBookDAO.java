package by.itac.mylibrary.dao;

import java.util.List;

import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public interface FindBookDAO {
	
	Book find(int id) throws DAOException;
	List<Book> findByTitle(String title) throws DAOException;
	List<Book> findByAuthor(String author) throws DAOException;

}
