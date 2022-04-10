package com.example.journal.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)	
	@JoinColumn(name = "subjectId")
	Set<CTSMtM> classyearTeacher;
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)	
	@JoinColumn(name = "subjectId")
	Set<Mark> marks;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)	
	@JoinColumn(name = "subjectId")
	Set<Remark> remark;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Subject(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name 
				+ "]";
	}
}
