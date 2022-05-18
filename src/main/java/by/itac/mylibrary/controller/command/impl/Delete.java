package by.itac.mylibrary.controller.command.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class Delete implements Command {

	@Override
	public String execute(String request) {
		final int id_Index = 1;
		final int author_Index = 2;
		final int title_Index = 3;
		final int year_Index = 4;
		final String paramDelimeter = " ";

		String[] param = request.split(paramDelimeter);

		String response = null;

		if (param.length == 5) {

			Book book = new Book(Integer.parseInt(param[id_Index]), param[author_Index], param[title_Index],
					Integer.parseInt(param[year_Index]));

			ServiceProvider serviceProvider = ServiceProvider.getInstance();

			BookService bookService = serviceProvider.getBookService();
			try {
				bookService.delete(book);
				response = "Book is deleted successfully";
			} catch (ServiceException e) {
				response = "Error duiring delete procedure";
			}
		} else
		if (param.length == 2) {
			int id = Integer.parseInt(param[id_Index]);

			ServiceProvider serviceProvider = ServiceProvider.getInstance();

			BookService bookService = serviceProvider.getBookService();
			try {
				bookService.delete(id);
				response = "Book is deleted successfully";
			} catch (ServiceException e) {
				response = "Error duiring delete procedure";
			}
		} else {
			response = "Error during delete procedure, incorrect parameters";
		}
		return response;
	}
}

