package com.example.journal.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



/**
 * @author aforu
 * 
 * Entity represents students parent or caretaker.
 * 
 *
 */
@Entity
public class Caretaker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String pwd;
	@OneToMany(mappedBy = "caretakerId", cascade = CascadeType.ALL, orphanRemoval = true)	
	Set<Student> students;
	
	
	
	public Caretaker() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Caretaker(String firstName, String lastName, String phone, String email, String pwd) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.pwd = pwd;
	}

	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
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



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	@Override
	public String toString() {
		return "Caretaker [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", email=" + email + ", pwd=" + pwd + "]";
	}
	
	
	
	
	
	
}
