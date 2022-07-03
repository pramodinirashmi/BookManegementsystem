package com.example.BookManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity // specifies that java class is mapped to database table.
@Table(name = "USERS") // this annotation is used to specify that particular table is mapped to.
public class User {

	@Id // specifies that primary key of entity.
	@GeneratedValue(generator = "USERSseq", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="USERSseq",initialValue = 200)
	@Column(name = "user_id")
	private long userId;

	@Column(name = "username", length = 100, nullable = false) // used for add column in specific table.
	private String userName;

	@Column(name = "password", length = 100, nullable = false)
	@Length(min = 8, max = 16, message = "password should be 8 to 16 characters.")
	private String password;

	@Email(message = "email is not well formed")
	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "phoneNo", unique = true)
	@Pattern(regexp = "^[0-9]{10}", message = "Phone number cannnot be less than 10 characters.")
	private String phoneNumber;

	public User() {

	}

	public User(long userId, String userName,
			@Length(min = 8, max = 16, message = "password should be 8 to 16 characters.") String password,
			@Email(message = "email is not well formed") String email, String firstName, String lastName,
			@Pattern(regexp = "^[0-9]{10}", message = "Phone number cannnot be less than 10 characters.") String phoneNumber) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
