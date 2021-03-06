package com.example.journal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.journal.dto.SubjectClassStudentDTO;
import com.example.journal.dto.SubjectDTO;
import com.example.journal.dto.TeacherDTO;
import com.example.journal.entities.Classyear;
import com.example.journal.entities.Mark;
import com.example.journal.entities.Student;
import com.example.journal.entities.Subject;
import com.example.journal.entities.Teacher;
import com.example.journal.repositories.MarkRepository;
import com.example.journal.repositories.TeacherRepository;


@Service
public class TeacherManager {

	private final TeacherRepository teacherRepository;
	private final MarkRepository markRepository;

	@Autowired
	public TeacherManager(TeacherRepository teacherRepository,MarkRepository markRepository) {
		super();
		this.teacherRepository = teacherRepository;
		this.markRepository = markRepository;
	}
	
	public SubjectDTO mapSubject(Subject subject, Classyear classyear, Teacher teacher) {
		SubjectDTO dto = new SubjectDTO(subject, classyear,teacher);
		return dto;
	}
	
	public TeacherDTO mapTeacher(Teacher teacher, String email) {
		TeacherDTO dto = new TeacherDTO(teacher,email);
		return dto;
	}
	
	public SubjectClassStudentDTO mapStudent(Student student, List<Mark> mark) {
		SubjectClassStudentDTO classStudentDTO = new SubjectClassStudentDTO(student, mark);
		return classStudentDTO;
	}
	
	public List<SubjectDTO> findSubjects(Long teacherId){
		List<Object[]> list = teacherRepository.findSubjects(teacherId);
		List<SubjectDTO> listDTO = new ArrayList<SubjectDTO>();
		for(int i =0; i< list.size();i++) {
			listDTO.add(mapSubject((Subject)list.get(i)[0], (Classyear)list.get(i)[1], 
					(Teacher)list.get(i)[2]));
		}
		return listDTO;
	}
	
	public String findEmailById(Long teacherId) {
		return teacherRepository.findEmailById(teacherId);
	}
	
	public List<SubjectDTO> findClassyearBySubject(Long teacherId, Long subjectId){
		List<Object[]> list = teacherRepository.findClassyearsBySubject(teacherId, subjectId);
		List<SubjectDTO> listDTO = new ArrayList<SubjectDTO>();
		for(int i =0; i< list.size();i++) {
			
			listDTO.add(mapSubject((Subject)list.get(i)[0], (Classyear)list.get(i)[1],
					(Teacher)list.get(i)[2]));
		}
		return listDTO;
	}
	
	
	public List<SubjectClassStudentDTO> findStudentsByClassAndSubject(Long teacherId, 
			Long subjectId, Long classyearId)
	{
		List<Object[]> list = teacherRepository.findStudentsByClassAndSubject(teacherId, subjectId, classyearId);
		List<SubjectClassStudentDTO> listDTO = new ArrayList<SubjectClassStudentDTO>();
		for(int i =0; i < list.size();i++) {
			Student tmp = (Student)list.get(i)[0];
			List<Mark> marks = teacherRepository.findStudentMarksBySubject(tmp.getId(), subjectId);
			listDTO.add(mapStudent((Student)list.get(i)[0], marks));
		}
		return listDTO;
	}
	
	// Add a mark
	public void addMark(Mark mark) {
		markRepository.save(mark);
	}
	
	//delete mark
	public void deleteMarkById(Long markId) {
		markRepository.deleteById(markId);
	}
	
	//update mark
	public void updateMark(Long markId, double newValue, Long newWeight, String newDescr, Long newStudentId) {
		Mark mark = markRepository.findById(markId).get();
		mark.setValue(newValue);
		mark.setWeight(newWeight);
		mark.setType(newDescr);
		mark.setStudentId(newStudentId);
		markRepository.save(mark);
	}

	public TeacherDTO findById(Long id) {
		Optional<Teacher> tc = teacherRepository.findById(id);
		String email = teacherRepository.findEmailById(id);
		TeacherDTO dto = mapTeacher(tc.get(), email);
		return dto;
	}

	public Iterable<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	public Teacher save(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	public void deleteById(Long id) {
		teacherRepository.deleteById(id);
	}

	@EventListener(ApplicationReadyEvent.class)

	public void runAtStart() { 

	}

}