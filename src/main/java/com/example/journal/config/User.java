package com.example.journal.config;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.journal.entities.Caretaker;
import com.example.journal.entities.Student;
import com.example.journal.entities.Teacher;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UID")
	private Long id;
	private String email;
	private String pwd;
	private Long roleId;
	
	@OneToMany(mappedBy = "userId")
	Set<Student> student;
	
	@OneToMany(mappedBy = "userId")
	Set<Teacher> teacher;
	
	@OneToMany(mappedBy = "userId")
	Set<Caretaker> caretaker;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String email, String pwd, Long roleId) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.roleId = roleId;
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
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", pwd=" + pwd + ", roleId=" + roleId + "]";
	}	
}
