package com.example.journal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.journal.Entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("SELECT s from Student s WHERE s.caretakerId=?1")
	List<Student> findAllByCaretaker(Long id);
	

}
