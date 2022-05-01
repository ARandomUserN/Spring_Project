package com.example.journal.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.journal.entities.Mark;
import com.example.journal.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("SELECT s from Student s WHERE s.caretakerId=?1")
	List<Student> findAllByCaretaker(Long id);
	
	
	@Query("SELECT s,c,y FROM Student s, Caretaker c, Classyear y"
			+ " WHERE s.caretakerId = c.id AND s.classyearId = y.id")
	List<Object[]> findAll1();
	
	@Query("SELECT s from Student s WHERE s.classyearId=?1")
	List<Student> findAllByClass(Long id);
	
	@Query("SELECT st,su,mk,tc FROM Student st, Subject su, Mark mk, Teacher tc, CTSMtM c "
			+ "WHERE st.id = ?1 "
			+ "AND mk.studentId = st.id "
			+ "AND mk.subjectId = c.subjectId "
			+ "AND c.subjectId = su.id "
			+ "AND tc.id = c.teacherId")
	List<Object[]> findStudentMarks(Long studentId);

}
