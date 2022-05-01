package com.example.journal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.journal.entities.Mark;

public interface MarkRepository extends JpaRepository<Mark, Long>{
	//All marks of student
	@Query("SELECT m FROM Mark m WHERE m.studentId = ?1")
	List<Mark> findMarks(Long studentId);
	
	//Marks of student from a subject
	@Query("SELECT m FROM Mark m WHERE m.studentId = ?1 AND m.studentId = ?2")
	List<Mark> findMarksByStudentSubject(Long studentId,Long subjectId);
	
	
	
}
