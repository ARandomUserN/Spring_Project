package com.example.journal.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classyear {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int year;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="classyearId")
	Set<Student> students;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="classyearId")
	Set<CTSMtM> teacherSubject;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="classyearId")
	Set<Subject> subjects;
	
	public Classyear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classyear(int year, String name) {
		super();
		this.year = year;
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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
		return "Classyear [id=" + id + ", year=" + year + ", name=" + name + "]\n";
	}
	
	
	
	
}
