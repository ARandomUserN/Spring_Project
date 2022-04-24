package com.example.journal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.journal.entities.Classyear;

public interface ClassyearRepository extends JpaRepository<Classyear, Long>{
	
	List<Classyear> findAll();

	@Query("SELECT c FROM Classyear c JOIN c.teacherSubject cc WHERE cc.subjectId = ?1")
	List<Classyear> AllBySubject(Long subjectId);

}
