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
import com.example.journal.entities.Caretaker;
import com.example.journal.entities.Classyear;
import com.example.journal.entities.Student;
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