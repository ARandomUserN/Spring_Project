package com.example.journal.services;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.journal.dto.StudentDTO;
import com.example.journal.dto.StudentMarksDTO;
import com.example.journal.dto.StudentRemarksDTO;
import com.example.journal.entities.Caretaker;
import com.example.journal.entities.Classyear;
import com.example.journal.entities.Mark;
import com.example.journal.entities.Remark;
import com.example.journal.entities.Student;
import com.example.journal.entities.Subject;
import com.example.journal.entities.Teacher;
import com.example.journal.repositories.CaretakerRepository;
import com.example.journal.repositories.ClassyearRepository;
import com.example.journal.repositories.StudentRepository;

@Service

public class StudentManager {

	private final StudentRepository studentRepository;
	private final CaretakerRepository caretakerRepository;
	private final ClassyearRepository classyearRepository;

	@Autowired
	public StudentManager(StudentRepository studentRepository, CaretakerRepository caretakerRepository,
			ClassyearRepository classyearRepository) {
		super();
		this.studentRepository = studentRepository;
		this.caretakerRepository = caretakerRepository;
		this.classyearRepository = classyearRepository;
	}
	
	//DTO Mapper  
	public StudentDTO mapStudent(Student student, Caretaker caretaker, Classyear classyear) {
		StudentDTO studentDTO = new StudentDTO(student.getId(), student.getFirstName(), student.getLastName(), 
				student.getPhone(), student.getEmail(), 
				caretaker.getFirstName(), caretaker.getLastName(), 
				classyear.getYear(), classyear.getName(),classyear.getId());
		return studentDTO;
	}
	
	public StudentMarksDTO mapMarks(Student student, Subject subject, Mark mark, Teacher teacher) {
		StudentMarksDTO dto = new StudentMarksDTO(student, subject.getId(), subject.getName(),
				teacher.getId(), teacher.getFirstName(), teacher.getLastName(),
				mark);
		return dto;
	}
	
	public StudentRemarksDTO mapRemarks(Student student, Subject subject, Remark remark, Teacher teacher) {
		StudentRemarksDTO dto = new StudentRemarksDTO(student, subject.getId(), subject.getName(),
				teacher.getId(), teacher.getFirstName(), teacher.getLastName(),
				remark);
		return dto;
	}
	
	public List<StudentMarksDTO> findStudentMarks(Long studentId){
		List<Object[]> list = studentRepository.findStudentMarks(studentId);
		
		List<StudentMarksDTO> markList = new ArrayList<StudentMarksDTO>();
		for(int i = 0; i < list.size();i++)
		{
			markList.add(mapMarks((Student)list.get(i)[0], (Subject)list.get(i)[1], (Mark)list.get(i)[2], (Teacher)list.get(i)[3]));
		}
		
		
		return markList;
	}
	
	public List<StudentRemarksDTO> findStudentRemarks(Long studentId){
		List<Object[]> list = studentRepository.findStudentRemarks(studentId);
		
		List<StudentRemarksDTO> markList = new ArrayList<StudentRemarksDTO>();
		for(int i = 0; i < list.size();i++)
		{
			markList.add(mapRemarks((Student)list.get(i)[0], (Subject)list.get(i)[1], (Remark)list.get(i)[2], (Teacher)list.get(i)[3]));
		}
		
		
		return markList;
	}
	

	public StudentDTO findById(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		Optional<Caretaker> caretaker = caretakerRepository.findById(student.get().getCaretakerId());
		Optional<Classyear> classyear = classyearRepository.findById(student.get().getClassyearId());
		
		StudentDTO result = mapStudent(student.get(), caretaker.get(), classyear.get());
		return result;
	}

	public List<StudentDTO> findAll() {
		List<Object[]> students = studentRepository.findAll1();
		
		List<StudentDTO> result = new ArrayList<StudentDTO>();
		
		for(int i =0; i < students.size(); i++) {
			StudentDTO x = mapStudent((Student)students.get(i)[0], (Caretaker)students.get(i)[1], (Classyear)students.get(i)[2]);
			result.add(x);
		}
		
		return result;
	}
	
	public List<Student> findAllByClass(Long classyearId){
		return studentRepository.findAllByClass(classyearId);
		
		
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}



	@EventListener(ApplicationReadyEvent.class)

	public void runAtStart() { 

	}

    

}