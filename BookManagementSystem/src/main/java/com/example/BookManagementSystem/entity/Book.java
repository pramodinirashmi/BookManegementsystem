package com.example.BookManagementSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "BOOK")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Book {

	@Id
	@GeneratedValue(generator = "BOOKseq", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="BOOKseq",initialValue = 500)
	@Column(name = "book_id")
	private int bookId;

	@Column(name = "ISBN")
	private String isbn;

	@NotNull
	@Column(name = "BOOK_NAME")
	private String bookName;

	@NotNull
	@Column(name = "published_Date")
	private String publishedDate;

	@NotNull
	@Column(name = "Pages")
	private String pages;

	@NotNull
	@Column(name = "DESCRIPTION")
	private String description;

	@NotNull
	@Column(name = "website")
	private String Website;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTHOR_ID")
	@JsonIgnore
	Author author;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher_id")
	@JsonIgnore
	private Publisher publisher;

	public Book() {
		super();
	}

	public Book(int bookId, String isbn, @NotNull String bookName, @NotNull String publishedDate, @NotNull String pages,
			@NotNull String description, @NotNull String website, Author author, Publisher publisher) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.bookName = bookName;
		this.publishedDate = publishedDate;
		this.pages = pages;
		this.description = description;
		Website = website;
		this.author = author;
		this.publisher = publisher;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", isbn=" + isbn + ", bookName=" + bookName + ", publishedDate="
				+ publishedDate + ", pages=" + pages + ", description=" + description + ", Website=" + Website
				+ ", author=" + author + ", publisher=" + publisher + "]";
	}

}
