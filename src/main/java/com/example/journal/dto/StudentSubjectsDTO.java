package com.example.journal.dto;

public record StudentSubjectsDTO(StudentDTO studentDTO, Long classyearId, 
		Long subjectId, String subjectName, 
		Long teacherId, String teacherFName, String teacherLName) {

}
