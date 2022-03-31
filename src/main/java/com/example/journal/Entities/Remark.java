package com.example.journal.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Remark {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String description;
	private long subjectId;
	private long studentId;
	public Remark(String description, long subjectId, long studentId) {
		super();
		this.description = description;
		this.subjectId = subjectId;
		this.studentId = studentId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Presence [id=" + id + ", description=" + description + ", subjectId=" + subjectId + ", studentId="
				+ studentId + "]";
	}
	
	
	
	
}
