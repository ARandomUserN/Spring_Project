package com.example.journal.services;

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
				classyear.getYear(), classyear.getName());
		return studentDTO;
	}

	public StudentDTO findById(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		Optional<Caretaker> caretaker = caretakerRepository.findById(student.get().getCaretakerId());
		Optional<Classyear> classyear = classyearRepository.findById(student.get().getClassyearId());
		
		StudentDTO studentDTO = mapStudent(student.get(), caretaker.get(), classyear.get());
		return studentDTO;
	}

	public Iterable<Student> findAll() {
		return studentRepository.findAll();
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}



	@EventListener(ApplicationReadyEvent.class)

	public void runAtStart() { 
		//    	Student s1 = new Student("Szymon", "Suchorab", "228857","228857@edu.p.lodz.pl", 0, 0);
		//		Student s2 = new Student("bbb", "bbb", "111","aaa", 0, 0);
		//		Student s3 = new Student("ccc", "bbb", "111","aaa", 0, 0);
		//		Student s4 = new Student("ddd", "bbb", "111","aaa", 0, 0);
		//		
		//		
		//		studentRepository.save(s1);		
		//		studentRepository.save(s2);		
		//		studentRepository.save(s3);		
		//		studentRepository.save(s4);
	}

    

}