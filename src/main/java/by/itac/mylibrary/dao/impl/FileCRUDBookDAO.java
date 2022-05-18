package by.itac.mylibrary.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.URL;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class FileCRUDBookDAO implements CRUDBookDAO {

	private final File file = new File("./src/main/resources/db-home-library.txt");
	private final static int ID_INDEX = 0;

	private final String separator = "__ __";
	
//	ClassLoader classLoader = getClass().getClassLoader();
//	 String path  = classLoader.getResource("db-home-library.txt").getPath();
//	 File file1 = new File(path);
	
	
	
//	File file1 = new File(getClass().getClassLoader().getResource("db-home-library.txt").getFile());
	
	
	
	
//	 ClassLoader classLoader = getClass().getClassLoader();
//	 
//     java.net.URL resource = classLoader.getResource("db-home-library.txt");
//     
//     File file1 = new File(resource.getFile());
	
	
	
	@Override
	public void save(Book book) throws DAOException {

		try (FileWriter fileWriter = new FileWriter(file, true)) {

			StringBuilder bookToSave = new StringBuilder();

			bookToSave.append(book.getId()).append(separator).append(book.getAuthor()).append(separator)
			.append(book.getTitle()).append(separator).append(book.getYear());

			fileWriter.write(bookToSave.toString() + System.lineSeparator());

		} catch (IOException e) {
			throw new DAOException("Input-output error");

		}

	}

	@Override
	public void update(int id, Book book) throws DAOException {

		int idOfBook;
		List<String> outputContent = new ArrayList<>();

		try (BufferedReader fileReader = new BufferedReader(new FileReader(file));
			 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {

			String bookInFile;
			StringBuilder updatedBook = new StringBuilder();

			while ((bookInFile = fileReader.readLine()) != null) {

				String[] bookFields = bookInFile.split(separator);
				idOfBook = Integer.parseInt(bookFields[ID_INDEX]);

				if (!(idOfBook == id)) {
					outputContent.add(bookInFile);
				} else {
					updatedBook.append(book.getId()).append(separator).append(book.getAuthor()).append(separator)
					.append(book.getTitle()).append(separator).append(book.getYear());
				
					outputContent.add(updatedBook.toString());
				}
			}

			deleteContentOfFile(file);
			
			for (String s : outputContent) {
				fileWriter.write(s);
				fileWriter.newLine();
			}

		} catch (IOException e) {
			throw new DAOException("Input-output error");
		}

	}

	@Override
	public void delete(int id) throws DAOException {

		int idOfBook;
		List<String> outputContent = new ArrayList<>();

		try (BufferedReader fileReader = new BufferedReader(new FileReader(file));
			 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {

			String book;

			while ((book = fileReader.readLine()) != null) {

				String[] bookFields = book.split(separator);
				idOfBook = Integer.parseInt(bookFields[ID_INDEX]);
				if (!(idOfBook == id)) {
					outputContent.add(book);
				}
			}

			deleteContentOfFile(file);
			
			for (String s : outputContent) {
				fileWriter.write(s);
				fileWriter.newLine();
			}

		} catch (IOException e) {
			throw new DAOException("Input-output error");
		}

	}

	@Override
	public void delete(Book book) throws DAOException {

		List<String> outputContent = new ArrayList<>();
		StringBuilder bookToDelete = new StringBuilder();

		bookToDelete.append(book.getId()).append(separator).append(book.getAuthor()).append(separator)
		.append(book.getTitle()).append(separator).append(book.getYear());

		try (BufferedReader fileReader = new BufferedReader(new FileReader(file));
				BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {

			String bookInFIle;

			while ((bookInFIle = fileReader.readLine()) != null) {

				if (!(bookToDelete.toString().equals(bookInFIle))) {
					outputContent.add(bookInFIle);
				}
			}

			deleteContentOfFile(file);
			for (String s : outputContent) {
				fileWriter.write(s);
				fileWriter.newLine();
			}

		} catch (IOException e) {
			throw new DAOException("Input-output error");
		}

	}

	private void deleteContentOfFile(File file) throws IOException, DAOException {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(file, false))) {
			br.write("");
		} catch (IOException e) {
			throw new DAOException ("Error during  clearing file");
		}
	}
}
