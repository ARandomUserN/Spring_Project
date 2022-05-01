package com.example.journal.dto;


import com.example.journal.entities.Remark;
import com.example.journal.entities.Student;

public record StudentRemarksDTO(Student student, 
		Long subjectId, String subjectName, 
		Long teacherId, String teacherFName, String teacherLName,
		Remark remark) {
}
