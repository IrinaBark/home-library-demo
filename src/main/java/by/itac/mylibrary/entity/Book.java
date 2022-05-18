package by.itac.mylibrary.entity;

import java.io.Serializable;

public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String title;
	private String author;
	private String genre;
	private int year;
	private boolean isRead;

	private static final int DEFAULT_ID = 0;
	private static final String DEFAULT_TITLE = "Unnamed";
	
	public Book (int id, String title) {
		this.id = id;
		this.title = title;
	}
    public Book () {
    	this(DEFAULT_ID, DEFAULT_TITLE);
    }
    public Book (int id, String author, String title, int year) {
    	this(id, title);
    	this.author = author;
    	this.year = year;
    }
    
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	
	
	public static int getDefaultId() {
		return DEFAULT_ID;
	}
	public static String getDefaultTitle() {
		return DEFAULT_TITLE;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + (isRead ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id != other.id)
			return false;
		if (isRead != other.isRead)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + ", year=" + year
				+ ", isRead=" + isRead + "]";
	}
	
}
