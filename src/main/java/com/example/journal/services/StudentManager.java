package com.example.journal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.journal.entities.Student;
import com.example.journal.repositories.StudentRepository;

@Service

public class StudentManager {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentManager(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
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