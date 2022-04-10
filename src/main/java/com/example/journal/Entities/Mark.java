package com.example.journal.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mark {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private double value;
	private long weight;
	private String type;
	private long subjectId;
	private long studentId;
	
	public Mark() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mark(double value, long weight, long subjectId, long studentId,String type) {
		super();
		this.value = value;
		this.weight = weight;
		this.subjectId = subjectId;
		this.studentId = studentId;
		this.type = type;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public long getWeight() {
		return weight;
	}
	
	public void setWeight(long weight) {
		this.weight = weight;
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "marks [id=" + id + ", value=" + value + ", weight=" + weight + ", type=" + type + ", subjectId="
				+ subjectId + ", studentId=" + studentId + "]";
	}
}
