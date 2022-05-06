package com.example.journal.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String phone;
	private long caretakerId;
	private long classyearId;
	private long userId;
	

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)	
	@JoinColumn(name="studentId")
	Set<Mark> marks;
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)	
	@JoinColumn(name="studentId")
	Set<Remark> remark;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, String phone, long caretakerId,
			long classyearId,long userId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.caretakerId = caretakerId;
		this.classyearId = classyearId;
		this.userId = userId;
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCaretakerId() {
		return caretakerId;
	}

	public void setCaretakerId(long caretakerId) {
		this.caretakerId = caretakerId;
	}

	public long getClassyearId() {
		return classyearId;
	}

	public void setClassyearId(long classyearId) {
		this.classyearId = classyearId;
	}

	public long getId() {
		return id;
	}

	

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", caretakerId=" + caretakerId + ", classyearId=" + classyearId
				+ "]\n";
	}
}
