package com.example.BookManagementSystem.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTHOR")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Author {
	@Id
	@GeneratedValue(generator = "AUTHORseq", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="AUTHORseq",initialValue = 300)
	@Column(name = "AUTHOR_ID")
	Integer authorId;

	@NotNull
	@Column(name = "AUTHOR_NAME")
	String authorName;

	@Email(message = "email is not well formed")
	@Column(name = "email", unique = true)
	private String email;

	@NotNull
	@Column(name = "Natinality")
	String nationality;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = { CascadeType.ALL })
	@JsonIgnore
	List<Book> booksList = new ArrayList<>();

	public void add(Book tempBook) {
		if (booksList == null) {
			booksList = new ArrayList<>();
		}
		// this is bi-directional relationship
		booksList.add(tempBook);
		tempBook.setAuthor(this);
	}

	public Author() {
		super();
	}

	public Author(Integer authorId, @NotNull String authorName,
			@Email(message = "email is not well formed") String email, @NotNull String nationality,
			List<Book> booksList) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.email = email;
		this.nationality = nationality;
		this.booksList = booksList;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public List<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", email=" + email + ", nationality="
				+ nationality + ", booksList=" + booksList + "]";
	}

}