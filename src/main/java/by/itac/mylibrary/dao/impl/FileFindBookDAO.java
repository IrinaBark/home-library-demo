package by.itac.mylibrary.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class FileFindBookDAO implements FindBookDAO {

	private final File file = new File("./src/main/resources/db-home-library.txt");
	
	private final static String SEPARATOR = "__ __";
	private final static int ID_INDEX = 0;
	private final static int AUTHOR_INDEX = 1;
	private final static int TITLE_INDEX = 2;
	private final static int YEAR_INDEX = 3;

	@Override
	public Book find(int id) throws DAOException {
		int idOfBook;
		Book foundBook = new Book();

		try (BufferedReader fileReader = new BufferedReader(new FileReader(file));
			 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))) {

			String book;

			while ((book = fileReader.readLine()) != null) {

				String[] bookFields = book.split(SEPARATOR);
				idOfBook = Integer.parseInt(bookFields[ID_INDEX]);
				if (idOfBook == id) {
					foundBook.setId(idOfBook);
					foundBook.setAuthor(bookFields[AUTHOR_INDEX]);
					foundBook.setTitle(bookFields[TITLE_INDEX]);
					foundBook.setYear(Integer.parseInt(bookFields[YEAR_INDEX]));
				}

			}
		} catch (IOException e) {
			throw new DAOException("Input-output error");
		}
		return foundBook;

	}

	@Override
	public List<Book> findByTitle(String title) throws DAOException {

		List<Book> foundBooks = new ArrayList<>();
		Book foundBook = new Book();

		try (BufferedReader fileReader = new BufferedReader(new FileReader(file));
				BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))) {

			String book;

			while ((book = fileReader.readLine()) != null) {

				String[] bookFields = book.split(SEPARATOR);

				if (title.equals(bookFields[TITLE_INDEX])) {

					foundBook.setId(Integer.parseInt(bookFields[ID_INDEX]));
					foundBook.setAuthor(bookFields[AUTHOR_INDEX]);
					foundBook.setTitle(bookFields[TITLE_INDEX]);
					foundBook.setYear(Integer.parseInt(bookFields[YEAR_INDEX]));
					
					foundBooks.add(foundBook);
				}

			}
		} catch (IOException e) {
			throw new DAOException("Input-output error");
		}
		return foundBooks;

	}

	public List<Book> findByAuthor(String author) throws DAOException {
		
		List<Book> foundBooks = new ArrayList<>();
		Book foundBook = new Book();

		try (BufferedReader fileReader = new BufferedReader(new FileReader(file));
				BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))) {

			String book;

			while ((book = fileReader.readLine()) != null) {

				String[] bookFields = book.split(SEPARATOR);

				if (author.equals(bookFields[AUTHOR_INDEX])) {

					foundBook.setId(Integer.parseInt(bookFields[ID_INDEX]));
					foundBook.setAuthor(bookFields[AUTHOR_INDEX]);
					foundBook.setTitle(bookFields[TITLE_INDEX]);
					foundBook.setYear(Integer.parseInt(bookFields[YEAR_INDEX]));
					foundBooks.add(foundBook);
				}

			}
		} catch (IOException e) {
			throw new DAOException("Input-output error");
		}
		return foundBooks;

	}

}
