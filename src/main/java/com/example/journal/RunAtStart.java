package com.example.journal;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.journal.entities.CTSMtM;
import com.example.journal.entities.Caretaker;
import com.example.journal.entities.Classyear;
import com.example.journal.entities.Mark;
import com.example.journal.entities.Remark;
import com.example.journal.entities.Student;
import com.example.journal.entities.Subject;
import com.example.journal.entities.Teacher;
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
		Caretaker c1 = new Caretaker("Karol", "Pawłowski", "567895436","tatajanka@gmail.com");
		Caretaker c2 = new Caretaker("Karina", "Zink", "768547567","szlachataniepracuje@interia.pl");
		Caretaker c3 = new Caretaker("Bianka", "Jankowska", "721671575","BiankaJ@gmail.com");
		Caretaker c4 = new Caretaker("Diana", "Walczak", "231456774","DianaW@interia.pl");
		Caretaker c5 = new Caretaker("Cecylia", "Zakrzewska", "251566757","CecyliaZ@gmail.com");
		Caretaker c6 = new Caretaker("Marlena", "Włodarczyk", "109604987","MarlenaW@interia.pl");
		Caretaker c7 = new Caretaker("Alicja", "Jasińska", "314204895","AlicjaJ@gmail.com");
		Caretaker c8 = new Caretaker("Oktawia", "Wasilewska", "640141548","OktawiaW@interia.pl");
		Caretaker c9 = new Caretaker("Norbert", "Lis", "72327175","NorbertL@gmail.com");
		Caretaker c10 = new Caretaker("Roman", "Jasiński", "735450527","RomanJ@interia.pl");
		Caretaker c11 = new Caretaker("Konstanty", "Stępień", "453788747","KonstantyS@gmail.com");
		Caretaker c12 = new Caretaker("Marian", "Tomaszewski", "945025041","MarianT@interia.pl");
		
		caretakerRepository.save(c1);
		caretakerRepository.save(c2);
		caretakerRepository.save(c3);
		caretakerRepository.save(c4);
		caretakerRepository.save(c5);
		caretakerRepository.save(c6);
		caretakerRepository.save(c7);
		caretakerRepository.save(c8);
		caretakerRepository.save(c9);
		caretakerRepository.save(c10);
		caretakerRepository.save(c11);
		caretakerRepository.save(c12);
		
		Classyear y1 = new Classyear(1, "A");
		Classyear y2 = new Classyear(1, "B");
		Classyear y3 = new Classyear(1, "C");
		Classyear y4 = new Classyear(2, "A");
		Classyear y5 = new Classyear(2, "B");
		Classyear y6 = new Classyear(2, "C");
		
		classyearRepository.save(y1);
		classyearRepository.save(y2);
		classyearRepository.save(y3);
		classyearRepository.save(y4);
		classyearRepository.save(y5);
		classyearRepository.save(y6);
		
		
		Student s1 = new Student("Szymon", "Suchor", "669666420","fajnygimail@interia.pl", c2.getId(), y1.getId());
		Student s2 = new Student("Jan", "Pawłowski", "521371337","misiaczek1337@gmail.com", c1.getId(), y1.getId());
		Student s3 = new Student("Adrzej", "Bryś", "734512378","quietkid@wp.pl", c1.getId(), y1.getId());
		Student s4 = new Student("Damian", "Rosomak", "678345786","rosomak@onet.pl", c2.getId(), y1.getId());
		
		studentRepository.save(s1);		
		studentRepository.save(s2);		
		studentRepository.save(s3);		
		studentRepository.save(s4);
		
		
		Teacher t1 = new Teacher("Jowita", "Bąk", "645674346", "jowita.bak@o2.pl"); 					
		Teacher t2 = new Teacher("Krzysztof", "Wojtasik", "567876541", "krzysztof.wojtasik@yahoo.com"); 
		Teacher t3 = new Teacher("Grażyna", "Koniczyna", "567435767", "grazka.koniczynka@interia.pl");	
		Teacher t4 = new Teacher("Anna", "Andrzejczyk", "567890442", "AA@yahoo.com");					
		Teacher t5 = new Teacher("Adrian", "Szulc", "357465716", "AS@yahoo.com");						
		Teacher t6 = new Teacher("Edward", "Makowski", "655787621", "EM@yahoo.com");					
		Teacher t7 = new Teacher("Gabriel", "Adamski", "876941442", "GA@yahoo.com");					
		Teacher t8 = new Teacher("Alek", "Woźniak", "987564354", "AW@yahoo.com");						
		Teacher t9 = new Teacher("Ernest", "Wiśniewski", "674236684", "EW@yahoo.com");					
		Teacher t10 = new Teacher("Iga", "Zawadzka", "687732146", "IZ@yahoo.com");						
		Teacher t11 = new Teacher("Olga", "Kubiak", "321654568", "OK@yahoo.com");						
		Teacher t12 = new Teacher("Anita", "Jakubowska", "357498723", "AJ@yahoo.com");					
		Teacher t13 = new Teacher("Joanna", "Wasilewska", "562213846", "JW@yahoo.com");					
		Teacher t14 = new Teacher("Mirosława", "Rutkowska", "657125222", "MR@yahoo.com");				
		
		teacherRepository.save(t1);
		teacherRepository.save(t2);
		teacherRepository.save(t3);
		teacherRepository.save(t4);
		teacherRepository.save(t5);
		teacherRepository.save(t6);
		teacherRepository.save(t7);
		teacherRepository.save(t8);
		teacherRepository.save(t9);
		teacherRepository.save(t10);
		teacherRepository.save(t11);
		teacherRepository.save(t12);
		teacherRepository.save(t13);
		teacherRepository.save(t14);
		
		Subject su1 = new Subject("Matematyka");		
		Subject su2 = new Subject("Język polski"); 	
		Subject su3 = new Subject("Język angielski");
		Subject su4 = new Subject("Historia");		
		Subject su5 = new Subject("Religia");			
		Subject su6 = new Subject("Wychowanie fizyczne");
		Subject su7 = new Subject("Technika");			
		Subject su8 = new Subject("Biologia");			
		Subject su9 = new Subject("Geografia");			
		Subject su10 = new Subject("Plastyka");			
		Subject su11 = new Subject("Informatyka");		
		Subject su12 = new Subject("Wiedza o społeczeństwie");
		Subject su13 = new Subject("Wychowaniu do życia w rodzinie");
		Subject su14 = new Subject("Muzyka");			
		Subject su15 = new Subject("Zajęcia z wychowawcą");
		Subject su16 = new Subject("Chemia");		
		Subject su17 = new Subject("Fizyka");		
		Subject su18 = new Subject("Przyroda");

		subjectRepository.save(su1);
		subjectRepository.save(su2);
		subjectRepository.save(su3);
		subjectRepository.save(su4);
		subjectRepository.save(su5);
		subjectRepository.save(su6);
		subjectRepository.save(su7);
		subjectRepository.save(su8);
		subjectRepository.save(su9);
		subjectRepository.save(su10);
		subjectRepository.save(su11);
		subjectRepository.save(su12);
		subjectRepository.save(su13);
		subjectRepository.save(su14);
		subjectRepository.save(su15);
		subjectRepository.save(su16);
		subjectRepository.save(su17);
		subjectRepository.save(su18);
		
		CTSMtM mtm1 = new CTSMtM(y1.getId(), su1.getId(), t1.getId());
		CTSMtM mtm2 = new CTSMtM(y2.getId(), su1.getId(), t1.getId());
		CTSMtM mtm3 = new CTSMtM(y3.getId(), su1.getId(), t1.getId());
		CTSMtM mtm4 = new CTSMtM(y4.getId(), su1.getId(), t1.getId());
		CTSMtM mtm5 = new CTSMtM(y5.getId(), su1.getId(), t1.getId());
		CTSMtM mtm6 = new CTSMtM(y6.getId(), su1.getId(), t1.getId());
		
		CTSMtM mtm7 = new CTSMtM(y1.getId(), su2.getId(), t2.getId());
		CTSMtM mtm8 = new CTSMtM(y2.getId(), su2.getId(), t2.getId());
		CTSMtM mtm9 = new CTSMtM(y3.getId(), su2.getId(), t2.getId());
		CTSMtM mtm10 = new CTSMtM(y4.getId(), su2.getId(), t2.getId());
		CTSMtM mtm11 = new CTSMtM(y5.getId(), su2.getId(), t2.getId());
		CTSMtM mtm12 = new CTSMtM(y6.getId(), su2.getId(), t2.getId());
		
		CTSMtM mtm13 = new CTSMtM(y1.getId(), su3.getId(), t3.getId());
		CTSMtM mtm14 = new CTSMtM(y2.getId(), su3.getId(), t3.getId());
		CTSMtM mtm15 = new CTSMtM(y3.getId(), su3.getId(), t3.getId());
		CTSMtM mtm16 = new CTSMtM(y4.getId(), su3.getId(), t3.getId());
		CTSMtM mtm17 = new CTSMtM(y5.getId(), su3.getId(), t3.getId());
		CTSMtM mtm18 = new CTSMtM(y6.getId(), su3.getId(), t3.getId());
		
		CTSMtM mtm19 = new CTSMtM(y1.getId(), su4.getId(), t4.getId());
		CTSMtM mtm20 = new CTSMtM(y2.getId(), su4.getId(), t4.getId());
		CTSMtM mtm21 = new CTSMtM(y3.getId(), su4.getId(), t4.getId());
		CTSMtM mtm22 = new CTSMtM(y4.getId(), su4.getId(), t4.getId());
		CTSMtM mtm23 = new CTSMtM(y5.getId(), su4.getId(), t4.getId());
		CTSMtM mtm24 = new CTSMtM(y6.getId(), su4.getId(), t4.getId());
		
		CTSMtM mtm25 = new CTSMtM(y1.getId(), su5.getId(), t5.getId());
		CTSMtM mtm26 = new CTSMtM(y2.getId(), su5.getId(), t5.getId());
		CTSMtM mtm27 = new CTSMtM(y3.getId(), su5.getId(), t5.getId());
		CTSMtM mtm28 = new CTSMtM(y4.getId(), su5.getId(), t5.getId());
		CTSMtM mtm29 = new CTSMtM(y5.getId(), su5.getId(), t5.getId());
		CTSMtM mtm30 = new CTSMtM(y6.getId(), su5.getId(), t5.getId());
		
		CTSMtM mtm31 = new CTSMtM(y1.getId(), su6.getId(), t6.getId());
		CTSMtM mtm32 = new CTSMtM(y2.getId(), su6.getId(), t6.getId());
		CTSMtM mtm33 = new CTSMtM(y3.getId(), su6.getId(), t6.getId());
		CTSMtM mtm34 = new CTSMtM(y4.getId(), su6.getId(), t6.getId());
		CTSMtM mtm35 = new CTSMtM(y5.getId(), su6.getId(), t6.getId());
		CTSMtM mtm36 = new CTSMtM(y6.getId(), su6.getId(), t6.getId());

		CTSMtM mtm37 = new CTSMtM(y1.getId(), su10.getId(), t7.getId());
		CTSMtM mtm38 = new CTSMtM(y2.getId(), su10.getId(), t7.getId());
		CTSMtM mtm39 = new CTSMtM(y3.getId(), su10.getId(), t7.getId());
		CTSMtM mtm40 = new CTSMtM(y4.getId(), su7.getId(), t7.getId());
		CTSMtM mtm41 = new CTSMtM(y5.getId(), su7.getId(), t7.getId());
		CTSMtM mtm42 = new CTSMtM(y6.getId(), su7.getId(), t7.getId());
		
		CTSMtM mtm43 = new CTSMtM(y1.getId(), su12.getId(), t10.getId());
		CTSMtM mtm44 = new CTSMtM(y2.getId(), su12.getId(), t10.getId());
		CTSMtM mtm45 = new CTSMtM(y3.getId(), su12.getId(), t10.getId());
		CTSMtM mtm46 = new CTSMtM(y1.getId(), su13.getId(), t10.getId());
		CTSMtM mtm47 = new CTSMtM(y2.getId(), su13.getId(), t10.getId());
		CTSMtM mtm48 = new CTSMtM(y3.getId(), su13.getId(), t10.getId());
		
		CTSMtM mtm49 = new CTSMtM(y1.getId(), su18.getId(), t8.getId());
		CTSMtM mtm50 = new CTSMtM(y2.getId(), su18.getId(), t8.getId());
		CTSMtM mtm51 = new CTSMtM(y3.getId(), su18.getId(), t8.getId());
		CTSMtM mtm52 = new CTSMtM(y4.getId(), su8.getId(), t8.getId());
		CTSMtM mtm53 = new CTSMtM(y5.getId(), su8.getId(), t8.getId());
		CTSMtM mtm54 = new CTSMtM(y6.getId(), su8.getId(), t8.getId());
		
		CTSMtM mtm55 = new CTSMtM(y4.getId(), su16.getId(), t9.getId());
		CTSMtM mtm56 = new CTSMtM(y5.getId(), su16.getId(), t9.getId());
		CTSMtM mtm57 = new CTSMtM(y6.getId(), su16.getId(), t9.getId());
		
		CTSMtM mtm58 = new CTSMtM(y1.getId(), su9.getId(), t11.getId());
		CTSMtM mtm59 = new CTSMtM(y2.getId(), su9.getId(), t11.getId());
		CTSMtM mtm60 = new CTSMtM(y3.getId(), su9.getId(), t11.getId());
		CTSMtM mtm61 = new CTSMtM(y4.getId(), su9.getId(), t11.getId());
		CTSMtM mtm62 = new CTSMtM(y5.getId(), su9.getId(), t11.getId());
		CTSMtM mtm63 = new CTSMtM(y6.getId(), su9.getId(), t11.getId());

		CTSMtM mtm64 = new CTSMtM(y1.getId(), su11.getId(), t12.getId());
		CTSMtM mtm65 = new CTSMtM(y2.getId(), su11.getId(), t12.getId());
		CTSMtM mtm66 = new CTSMtM(y3.getId(), su11.getId(), t12.getId());
		CTSMtM mtm67 = new CTSMtM(y4.getId(), su11.getId(), t12.getId());
		CTSMtM mtm68 = new CTSMtM(y5.getId(), su11.getId(), t12.getId());
		CTSMtM mtm69 = new CTSMtM(y6.getId(), su11.getId(), t12.getId());
		
		CTSMtM mtm70 = new CTSMtM(y4.getId(), su17.getId(), t13.getId());
		CTSMtM mtm71 = new CTSMtM(y5.getId(), su17.getId(), t13.getId());
		CTSMtM mtm72 = new CTSMtM(y6.getId(), su17.getId(), t13.getId());

		CTSMtM mtm73 = new CTSMtM(y1.getId(), su14.getId(), t14.getId());
		CTSMtM mtm74 = new CTSMtM(y2.getId(), su14.getId(), t14.getId());
		CTSMtM mtm75 = new CTSMtM(y3.getId(), su14.getId(), t14.getId());
		CTSMtM mtm76 = new CTSMtM(y4.getId(), su14.getId(), t14.getId());
		CTSMtM mtm77 = new CTSMtM(y5.getId(), su14.getId(), t14.getId());
		CTSMtM mtm78 = new CTSMtM(y6.getId(), su14.getId(), t14.getId());

		CTSMtM mtm79 = new CTSMtM(y1.getId(), su15.getId(), t1.getId());
		CTSMtM mtm80 = new CTSMtM(y2.getId(), su15.getId(), t5.getId());
		CTSMtM mtm81 = new CTSMtM(y3.getId(), su15.getId(), t14.getId());
		CTSMtM mtm82 = new CTSMtM(y4.getId(), su15.getId(), t7.getId());
		CTSMtM mtm83 = new CTSMtM(y5.getId(), su15.getId(), t3.getId());
		CTSMtM mtm84 = new CTSMtM(y6.getId(), su15.getId(), t10.getId());
		
		ctsMtMRepository.save(mtm1);
		ctsMtMRepository.save(mtm2);
		ctsMtMRepository.save(mtm3);
		ctsMtMRepository.save(mtm4);
		ctsMtMRepository.save(mtm5);
		ctsMtMRepository.save(mtm6);
		ctsMtMRepository.save(mtm7);
		ctsMtMRepository.save(mtm8);
		ctsMtMRepository.save(mtm9);
		ctsMtMRepository.save(mtm10);
		ctsMtMRepository.save(mtm11);
		ctsMtMRepository.save(mtm12);
		ctsMtMRepository.save(mtm13);
		ctsMtMRepository.save(mtm14);
		ctsMtMRepository.save(mtm15);
		ctsMtMRepository.save(mtm16);
		ctsMtMRepository.save(mtm17);
		ctsMtMRepository.save(mtm18);
		ctsMtMRepository.save(mtm19);
		ctsMtMRepository.save(mtm20);
		ctsMtMRepository.save(mtm21);
		ctsMtMRepository.save(mtm22);
		ctsMtMRepository.save(mtm23);
		ctsMtMRepository.save(mtm24);
		ctsMtMRepository.save(mtm25);
		ctsMtMRepository.save(mtm26);
		ctsMtMRepository.save(mtm27);
		ctsMtMRepository.save(mtm28);
		ctsMtMRepository.save(mtm29);
		ctsMtMRepository.save(mtm30);
		ctsMtMRepository.save(mtm31);
		ctsMtMRepository.save(mtm32);
		ctsMtMRepository.save(mtm33);
		ctsMtMRepository.save(mtm34);
		ctsMtMRepository.save(mtm35);
		ctsMtMRepository.save(mtm36);
		ctsMtMRepository.save(mtm37);
		ctsMtMRepository.save(mtm38);
		ctsMtMRepository.save(mtm39);
		ctsMtMRepository.save(mtm40);
		ctsMtMRepository.save(mtm41);
		ctsMtMRepository.save(mtm42);
		ctsMtMRepository.save(mtm43);
		ctsMtMRepository.save(mtm44);
		ctsMtMRepository.save(mtm45);
		ctsMtMRepository.save(mtm46);
		ctsMtMRepository.save(mtm47);
		ctsMtMRepository.save(mtm48);
		ctsMtMRepository.save(mtm49);
		ctsMtMRepository.save(mtm50);
		ctsMtMRepository.save(mtm51);
		ctsMtMRepository.save(mtm52);
		ctsMtMRepository.save(mtm53);
		ctsMtMRepository.save(mtm54);
		ctsMtMRepository.save(mtm55);
		ctsMtMRepository.save(mtm56);
		ctsMtMRepository.save(mtm57);
		ctsMtMRepository.save(mtm58);
		ctsMtMRepository.save(mtm59);
		ctsMtMRepository.save(mtm60);
		ctsMtMRepository.save(mtm61);
		ctsMtMRepository.save(mtm62);
		ctsMtMRepository.save(mtm63);
		ctsMtMRepository.save(mtm64);
		ctsMtMRepository.save(mtm65);
		ctsMtMRepository.save(mtm66);
		ctsMtMRepository.save(mtm67);
		ctsMtMRepository.save(mtm68);
		ctsMtMRepository.save(mtm69);
		ctsMtMRepository.save(mtm70);
		ctsMtMRepository.save(mtm71);
		ctsMtMRepository.save(mtm72);
		ctsMtMRepository.save(mtm73);
		ctsMtMRepository.save(mtm74);
		ctsMtMRepository.save(mtm75);
		ctsMtMRepository.save(mtm76);
		ctsMtMRepository.save(mtm77);
		ctsMtMRepository.save(mtm78);
		ctsMtMRepository.save(mtm79);
		ctsMtMRepository.save(mtm80);
		ctsMtMRepository.save(mtm81);
		ctsMtMRepository.save(mtm82);
		ctsMtMRepository.save(mtm83);
		ctsMtMRepository.save(mtm84);
		

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
