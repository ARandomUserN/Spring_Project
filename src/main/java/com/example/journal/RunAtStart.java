package com.example.journal;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.journal.Entities.CTSMtM;
import com.example.journal.Entities.Caretaker;
import com.example.journal.Entities.Classyear;
import com.example.journal.Entities.Mark;
import com.example.journal.Entities.Remark;
import com.example.journal.Entities.Student;
import com.example.journal.Entities.Subject;
import com.example.journal.Entities.Teacher;
import com.example.journal.repositories.CTSMtMRepository;
import com.example.journal.repositories.CaretakerRepository;
import com.example.journal.repositories.ClassyearRepository;
import com.example.journal.repositories.MarkRepository;
import com.example.journal.repositories.RemarksRepository;
import com.example.journal.repositories.StudentRepository;
import com.example.journal.repositories.SubjectRepository;
import com.example.journal.repositories.TeacherRepository;

@Component
public class RunAtStart {
	private final CaretakerRepository caretakerRepository;
	private final StudentRepository studentRepository;
	private final ClassyearRepository classyearRepository;
	private final MarkRepository markRepository;
	private final TeacherRepository teacherRepository;
	private final SubjectRepository subjectRepository;
	private final RemarksRepository remarksRepository;
	private final CTSMtMRepository ctsMtMRepository;
	
	
	@Autowired
	public RunAtStart(CaretakerRepository caretakerRepository, StudentRepository studentRepository,
			ClassyearRepository classyearRepository, MarkRepository markRepository, TeacherRepository teacherRepository,
			SubjectRepository subjectRepository, RemarksRepository remarksRepository,CTSMtMRepository ctsMtMRepository) {
		super();
		this.caretakerRepository = caretakerRepository;
		this.studentRepository = studentRepository;
		this.classyearRepository = classyearRepository;
		this.markRepository = markRepository;
		this.teacherRepository = teacherRepository;
		this.subjectRepository = subjectRepository;
		this.remarksRepository = remarksRepository;
		this.ctsMtMRepository = ctsMtMRepository;
	}

	
	@PostConstruct
	public void runAtStart() {
		Caretaker c1 = new Caretaker("aaa", "bbb", "111","aaa");
		Caretaker c2 = new Caretaker("bbb", "ccc", "222","bbb");
		
		caretakerRepository.save(c1);
		caretakerRepository.save(c2);
		
		Classyear y1 = new Classyear(1, "TI");
		Classyear y2 = new Classyear(2, "EL");
		
		classyearRepository.save(y1);
		classyearRepository.save(y2);
		
		Student s1 = new Student("aaa", "bbb", "111","aaa", c2.getId(), y1.getId());
		Student s2 = new Student("bbb", "bbb", "111","aaa", c1.getId(), y1.getId());
		Student s3 = new Student("ccc", "bbb", "111","aaa", c1.getId(), y1.getId());
		Student s4 = new Student("ddd", "bbb", "111","aaa", c2.getId(), y1.getId());
		
		studentRepository.save(s1);		
		studentRepository.save(s2);		
		studentRepository.save(s3);		
		studentRepository.save(s4);
		
		
		Teacher t1 = new Teacher("AAA", "AAA", "111", "AAA");
		Teacher t2 = new Teacher("BBB", "BBB", "222", "BBB");

		teacherRepository.save(t1);
		teacherRepository.save(t2);
		
		Subject su1 = new Subject("IT");
		Subject su2 = new Subject("MM");
		Subject su3 = new Subject("MM2");

		subjectRepository.save(su1);
		subjectRepository.save(su2);
		subjectRepository.save(su3);

		CTSMtM mtm1 = new CTSMtM(y1.getId(), su1.getId(), t1.getId());
		CTSMtM mtm2 = new CTSMtM(y1.getId(), su2.getId(), t2.getId());
		CTSMtM mtm3 = new CTSMtM(y1.getId(), su3.getId(), t1.getId());
		CTSMtM mtm4 = new CTSMtM(y2.getId(), su3.getId(), t2.getId());
		
		ctsMtMRepository.save(mtm1);
		ctsMtMRepository.save(mtm2);
		ctsMtMRepository.save(mtm3);
		ctsMtMRepository.save(mtm4);

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
		
		List<Student> ls = studentRepository.findAllByCaretaker((long) 1);
		for(Student sss: ls) {
			System.out.println(sss.toString());
		}
		
	}


	

	
}
