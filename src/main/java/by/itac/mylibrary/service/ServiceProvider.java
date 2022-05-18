package by.itac.mylibrary.service;

import by.itac.mylibrary.service.impl.BookServiceImpl;
import by.itac.mylibrary.service.impl.StatusBookServiceImpl;

public final class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();

	private BookService bookService = new BookServiceImpl();
	private StatusBookServcie statusBookService = new StatusBookServiceImpl();

	private ServiceProvider() {
	}

	public BookService getBookService() {
		return bookService;
	}

	public StatusBookServcie getStatusBookService() {
		return statusBookService;
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

}
