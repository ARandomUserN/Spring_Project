package com.example.journal.Entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	private long teacherId;
	private long classyearId;
	
	
	public Subject(String name, long teacherId, long classyearId) {
		super();
		this.name = name;
		this.teacherId = teacherId;
		this.classyearId = classyearId;
	}
	public String getName() {
		return name;
	}
	public long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public long getClassyearId() {
		return classyearId;
	}
	public void setClassyearId(long classyearId) {
		this.classyearId = classyearId;
	}
	
	
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", teacherId=" + teacherId + ", classyearId=" + classyearId
				+ "]";
	}
	
	
	
}
