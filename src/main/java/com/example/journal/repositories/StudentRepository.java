package com.example.journal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.journal.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("SELECT s from Student s WHERE s.caretakerId=?1")
	List<Student> findAllByCaretaker(Long id);
	
	
	@Query("SELECT s,c,y,u.email FROM Student s, Caretaker c, Classyear y, User u "
			+ "WHERE s.caretakerId = c.id "
			+ "AND s.classyearId = y.id "
			+ "AND u.id = s.userId")
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

	
	@Query("SELECT st,su,rm,tc FROM Student st, Subject su, Remark rm, Teacher tc, CTSMtM c "
			+ "WHERE st.id = ?1 "
			+ "AND rm.studentId = st.id "
			+ "AND rm.subjectId = c.subjectId "
			+ "AND c.subjectId = su.id "
			+ "AND tc.id = c.teacherId")
	List<Object[]> findStudentRemarks(Long studentId);
	
	@Query("SELECT u.email FROM Student s, User u "
			+ "WHERE s.id = ?1 "
			+ "AND u.id = s.userId")
	String findEmailById(Long studentId);
	
	@Query("SELECT s FROM Student s "
			+ "WHERE s.userId = ?1")
	Student findStudentByUser(Long userId);

}
