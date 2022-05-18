package by.itac.mylibrary.service.impl;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.DAOProvider;
import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.exception.ServiceException;

public class BookServiceImpl implements BookService {

	@Override
	public void save(Book book) throws ServiceException {
		// 1 VALIDATION INPUT DATA

		if (book == null) {
			throw new ServiceException("There is no book in the link");
		} else if (book.getTitle() == null || book.getTitle() == Book.getDefaultTitle()) {
			throw new ServiceException("Book without title cannot be saved");
		} else if (book.getId() == Book.getDefaultId()) {
			throw new ServiceException("Book without id cannot be saved");
		} else if (book.getAuthor() == null) {
			throw new ServiceException("Book without author cannot be saved");
		} else if (book.getYear() == 0) {
			throw new ServiceException("Book without year of publishing cannot be saved");
		}

		try {
			DAOProvider provider = DAOProvider.getInstance();
			CRUDBookDAO dao = provider.getBookDAO();
			dao.save(book);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	public Book findByID(int id) throws ServiceException {
		// VALIDATION INPUT DATA

		if (id < 0) {
			throw new ServiceException("Invalid ID");
		}
		Book book = new Book();
		try {
			DAOProvider provider = DAOProvider.getInstance();
			FindBookDAO dao = provider.getFindDAO();
			book = dao.find(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return book;

	}

	@Override
	public void delete(int id) throws ServiceException {
		// VALIDATION INPUT DATA

		if (id < 0) {
			throw new ServiceException("Invalid ID");
		}

		try {
			DAOProvider provider = DAOProvider.getInstance();
			CRUDBookDAO dao = provider.getBookDAO();
			dao.delete(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void delete(Book book) throws ServiceException {
		// 1 VALIDATION INPUT DATA

		if (book == null) {
			throw new ServiceException("There is no book in the link");
		} else if (book.getTitle() == null || book.getTitle() == Book.getDefaultTitle()) {
			throw new ServiceException("Book without title cannot be saved");
		} else if (book.getId() == Book.getDefaultId()) {
			throw new ServiceException("Book without id cannot be saved");
		} else if (book.getAuthor() == null) {
			throw new ServiceException("Book without author cannot be saved");
		} else if (book.getYear() == 0) {
			throw new ServiceException("Book without year of publishing cannot be saved");
		}

		try {
			DAOProvider provider = DAOProvider.getInstance();
			CRUDBookDAO dao = provider.getBookDAO();
			dao.delete(book);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void update(int id, Book book) throws ServiceException {
		// 1 VALIDATION INPUT DATA
		if (id < 0) {
			throw new ServiceException("Invalid id");
		} else if (book == null) {
			throw new ServiceException("There is no book in the link");
		} else if (book.getTitle() == null || book.getTitle() == Book.getDefaultTitle()) {
			throw new ServiceException("Book without title cannot be saved");
		} else if (book.getId() == Book.getDefaultId()) {
			throw new ServiceException("Book without id cannot be saved");
		} else if (book.getAuthor() == null) {
			throw new ServiceException("Book without author cannot be saved");
		} else if (book.getYear() == 0) {
			throw new ServiceException("Book without year of publishing cannot be saved");
		}

		try {
			DAOProvider provider = DAOProvider.getInstance();
			CRUDBookDAO dao = provider.getBookDAO();
			dao.update(id, book);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

}
