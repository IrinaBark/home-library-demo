package by.itac.mylibrary.dao;

import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public interface CRUDBookDAO {
	void save(Book book) throws DAOException;
	void update(int id, Book book) throws DAOException;
	void delete(Book book) throws DAOException;
	void delete(int id) throws DAOException;

}
