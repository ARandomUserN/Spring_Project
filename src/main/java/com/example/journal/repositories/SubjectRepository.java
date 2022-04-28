package com.example.journal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.journal.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
	
	@Query("SELECT s FROM Subject s JOIN s.classyearTeacher ct WHERE ct.teacherId = ?1")
	List<Subject> findByTeacher(Long teacherId);
	
	@Query("SELECT s FROM Subject s JOIN s.classyearTeacher ct WHERE ct.classyearId = ?1")
	List<Subject> findByClassyear(Long classyearId);
}
