package com.example.journal.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private long userId;
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="caretakerId")
	Set<Student> students;
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Caretaker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Caretaker(String firstName, String lastName, String phone, long userId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.userId = userId;
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
	
	@Override
	public String toString() {
		return "Caretaker [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ "]";
	}
}
