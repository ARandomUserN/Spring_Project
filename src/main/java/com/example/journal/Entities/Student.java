package com.example.journal.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String pwd;
	
	private long caretakerId;

	private long classyearId;
	
//	@OneToMany(mappedBy = "mk_studentId", cascade = CascadeType.ALL, orphanRemoval = true)	
//	Set<Mark> marks;
//	
//	@OneToMany(mappedBy = "pr_studentId", cascade = CascadeType.ALL, orphanRemoval = true)	
//	Set<PresenceJournal> presence;
//	
//	@OneToMany(mappedBy = "rk_studentId", cascade = CascadeType.ALL, orphanRemoval = true)	
//	Set<Remarks> remarks;

	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, String phone, String email, String pwd, long caretakerId,
			long classyearId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.pwd = pwd;
		this.caretakerId = caretakerId;
		this.classyearId = classyearId;
	}
	
	public Student(String firstName, String lastName, String phone, String email, String pwd, long caretakerId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.pwd = pwd;
		this.caretakerId = caretakerId;
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
				+ ", email=" + email + ", pwd=" + pwd + ", caretakerId=" + caretakerId + ", classyearId=" + classyearId
				+ "]\n";
	}
	
	
	
	
	
}
