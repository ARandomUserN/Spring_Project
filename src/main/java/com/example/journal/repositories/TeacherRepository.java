package com.example.journal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.journal.entities.Subject;
import com.example.journal.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	// lista przedmiotów
	@Query("SELECT su, cl, tc FROM Subject su, Classyear cl, Teacher tc, CTSMtM c "
			+ "WHERE tc.id = ?1 "
			+ "AND tc.id = c.teacherId "
			+ "AND cl.id = c.classyearId "
			+ "AND c.subjectId = su.id")
	List<Object[]> findSubjects(Long teacherId);
	
	// lista klas z danego przedmiotu
	@Query("SELECT su, cl, tc FROM Classyear cl, Subject su, Teacher tc, CTSMtM c "
			+ "WHERE tc.id = ?1 "
			+ "AND su.id = ?2 "
			+ "AND tc.id = c.teacherId "
			+ "AND cl.id = c.classyearId "
			+ "AND su.id = c.subjectId")
	List<Object[]> findClassyearsBySubject(Long teacherId, Long subjectId);

	// lista uczniów w klasie w danym przedmiocie (uczen, oceny)
	@Query("SELECT st, su, mk FROM Student st, Mark mk, Subject su, Teacher tc, CTSMtM c "
			+ "WHERE tc.id = ?1 "
			+ "AND su.id = ?2 "
			+ "AND st.classyearId = ?3 "
			+ "AND st.id = mk.studentId "
			+ "AND mk.subjectId = su.id "
			+ "AND su.id = c.subjectId "
			+ "AND c.teacherId = tc.id")
	List<Object[]> findStudentsByClassAndSubject(Long teacherId, Long subjectId, Long classyearId);
}
