package com.example.journal.dto;


import com.example.journal.entities.Mark;
import com.example.journal.entities.Student;

public record StudentMarksDTO(Student student, 
		String email,
		Long subjectId, String subjectName, 
		Long teacherId, String teacherFName, String teacherLName,
		Mark mark) {

}
