package com.example.BookManagementSystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PUBLISHER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Publisher {
	@Id
	@GeneratedValue(generator = "PUBLISHERseq", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="PUBLISHERseq",initialValue = 400)
	@Column(name = "publisher_id")
	private int publisherId;

	@Column(name = "PUBLISHER_NAME")
	private String publisherName;

	@Email(message = "email is not well formed")
	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "phoneNo", unique = true)
	@Pattern(regexp = "^[0-9]{10}", message = "Phone number cannnot be less than 10 characters.")
	private String phoneNumber;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publisher", cascade = { CascadeType.ALL })
	@JsonIgnore
	List<Book> booksList = new ArrayList<>();

	public Publisher() {
		super();
	}

	public Publisher(int publisherId, String publisherName, @Email(message = "email is not well formed") String email,
			@Pattern(regexp = "^[0-9]{10}", message = "Phone number cannnot be less than 10 characters.") String phoneNumber,
			List<Book> booksList) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.booksList = booksList;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}

	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", booksList=" + booksList + "]";
	}

}
