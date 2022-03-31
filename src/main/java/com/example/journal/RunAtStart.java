package com.example.journal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.journal.Entities.Caretaker;
import com.example.journal.Entities.Classyear;
import com.example.journal.Entities.Student;
import com.example.journal.Repositories.CaretakerRepository;
import com.example.journal.Repositories.ClassyearRepository;
import com.example.journal.Repositories.StudentRepository;

@Component
public class RunAtStart {
	private final CaretakerRepository caretakerRepository;
	private final StudentRepository studentRepository;
	private final ClassyearRepository classyearRepository;
	
	
	@Autowired
	public RunAtStart(CaretakerRepository caretakerRepository, StudentRepository studentRepository,
			ClassyearRepository classyearRepository) {
		super();
		this.caretakerRepository = caretakerRepository;
		this.studentRepository = studentRepository;
		this.classyearRepository = classyearRepository;
	}
	
	@PostConstruct
	public void runAtStart() {
		Caretaker c1 = new Caretaker("aaa", "bbb", "111");
		Caretaker c2 = new Caretaker("bbb", "ccc", "222");
		
		caretakerRepository.save(c1);
		caretakerRepository.save(c2);
		
		Classyear y1 = new Classyear(1, "TI");
		
		classyearRepository.save(y1);
		
		Student s1 = new Student("aaa", "bbb", "111", c2.getId(),y1.getId());
		
		studentRepository.save(s1);
		
		System.out.print(s1);
		
		
	}


	
}
