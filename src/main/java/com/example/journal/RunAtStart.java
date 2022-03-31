package com.example.journal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.journal.Entities.Caretaker;
import com.example.journal.Entities.Classyear;
import com.example.journal.Entities.Mark;
import com.example.journal.Entities.Remark;
import com.example.journal.Entities.Student;
import com.example.journal.Entities.Subject;
import com.example.journal.Entities.Teacher;
import com.example.journal.Repositories.CaretakerRepository;
import com.example.journal.Repositories.ClassyearRepository;
import com.example.journal.Repositories.MarkRepository;
import com.example.journal.Repositories.RemarksRepository;
import com.example.journal.Repositories.StudentRepository;
import com.example.journal.Repositories.SubjectRepository;
import com.example.journal.Repositories.TeacherRepository;

@Component
public class RunAtStart {
	private final CaretakerRepository caretakerRepository;
	private final StudentRepository studentRepository;
	private final ClassyearRepository classyearRepository;
	private final MarkRepository markRepository;
	private final TeacherRepository teacherRepository;
	private final SubjectRepository subjectRepository;
	private final RemarksRepository remarksRepository;
	
	
	@Autowired
	public RunAtStart(CaretakerRepository caretakerRepository, StudentRepository studentRepository,
			ClassyearRepository classyearRepository, MarkRepository markRepository, TeacherRepository teacherRepository,
			SubjectRepository subjectRepository, RemarksRepository remarksRepository) {
		super();
		this.caretakerRepository = caretakerRepository;
		this.studentRepository = studentRepository;
		this.classyearRepository = classyearRepository;
		this.markRepository = markRepository;
		this.teacherRepository = teacherRepository;
		this.subjectRepository = subjectRepository;
		this.remarksRepository = remarksRepository;
	}

	
	@PostConstruct
	public void runAtStart() {
		Caretaker c1 = new Caretaker("aaa", "bbb", "111","aaa");
		Caretaker c2 = new Caretaker("bbb", "ccc", "222","bbb");
		
		caretakerRepository.save(c1);
		caretakerRepository.save(c2);
		
		Classyear y1 = new Classyear(1, "TI");
		
		classyearRepository.save(y1);
		
		Student s1 = new Student("aaa", "bbb", "111","aaa", c2.getId(), y1.getId());
		Student s2 = new Student("aaa", "bbb", "111","aaa", c1.getId(), y1.getId());
		Student s3 = new Student("aaa", "bbb", "111","aaa", c1.getId(), y1.getId());
		Student s4 = new Student("aaa", "bbb", "111","aaa", c2.getId(), y1.getId());
		
		studentRepository.save(s1);		
		studentRepository.save(s2);		
		studentRepository.save(s3);		
		studentRepository.save(s4);
		
		
		Teacher t1 = new Teacher("AAA", "AAA", "111", "AAA");
		Teacher t2 = new Teacher("BBB", "BBB", "222", "BBB");

		teacherRepository.save(t1);
		teacherRepository.save(t2);
		
		Subject su1 = new Subject("IT", t1.getId(), y1.getId());
		Subject su2 = new Subject("MM", t2.getId(), y1.getId());

		subjectRepository.save(su1);
		subjectRepository.save(su2);

		Mark m1 = new Mark(4.0, 1, su1.getId(), s1.getId(), "test");
		Mark m2 = new Mark(3.0, 1, su1.getId(), s2.getId(), "test");
		Mark m3 = new Mark(5.0, 1, su1.getId(), s3.getId(), "test");
		Mark m4 = new Mark(2.0, 1, su1.getId(), s4.getId(), "test");

		markRepository.save(m1);
		markRepository.save(m2);
		markRepository.save(m3);
		markRepository.save(m4);
		
		Mark m5 = new Mark(2.0, 1, su2.getId(), s1.getId(), "tests2");
		Mark m6 = new Mark(2.0, 1, su2.getId(), s2.getId(), "tests2");
		Mark m7 = new Mark(2.0, 1, su2.getId(), s3.getId(), "tests2");

		markRepository.save(m5);
		markRepository.save(m6);
		markRepository.save(m7);
		
		Remark r1 = new Remark("BBBBBBB", su2.getId(), s1.getId());
		
		remarksRepository.save(r1);
		
		
		
	}


	

	
}
