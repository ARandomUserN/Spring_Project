package com.example.journal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/**
 * @author aforu
 *	Class is a composite key for many-to-many relationship between
 *	Subject, Teachers and Classyears
 */
@Entity
public class CTSMtM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long classyearId;
	private long subjectId;
	private long teacherId;
	
	public CTSMtM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CTSMtM(long classyearId, long subjectId, long teacherId) {
		super();
		this.classyearId = classyearId;
		this.subjectId = subjectId;
		this.teacherId = teacherId;
	}

	public long getClassyearId() {
		return classyearId;
	}

	public void setClassyearId(long classyearId) {
		this.classyearId = classyearId;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CTSMtM [id=" + id + ", classyearId=" + classyearId + ", subjectId=" + subjectId + ", teacherId="
				+ teacherId + "]";
	}
}
