package com.example.journal;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.journal.config.Role;
import com.example.journal.config.User;
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
import com.example.journal.repositories.RolesRepository;
import com.example.journal.repositories.StudentRepository;
import com.example.journal.repositories.SubjectRepository;
import com.example.journal.repositories.TeacherRepository;
import com.example.journal.repositories.UsersRepository;

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
	private final RolesRepository rolesRepository;
	private final UsersRepository usersRepository;
	
	@Autowired
	public RunAtStart(CaretakerRepository caretakerRepository, StudentRepository studentRepository,
			ClassyearRepository classyearRepository, MarkRepository markRepository, TeacherRepository teacherRepository,
			SubjectRepository subjectRepository, RemarksRepository remarksRepository,CTSMtMRepository ctsMtMRepository,
			RolesRepository rolesRepository,UsersRepository usersRepository) {
		super();
		this.caretakerRepository = caretakerRepository;
		this.studentRepository = studentRepository;
		this.classyearRepository = classyearRepository;
		this.markRepository = markRepository;
		this.teacherRepository = teacherRepository;
		this.subjectRepository = subjectRepository;
		this.remarksRepository = remarksRepository;
		this.ctsMtMRepository = ctsMtMRepository;
		this.rolesRepository = rolesRepository;
		this.usersRepository = usersRepository;
	}
	

	
	@PostConstruct
	public void runAtStart() {
		Role r1 = new Role("STUDENT");
		Role r2 = new Role("ADMIN");
		Role r3 = new Role("CARETAKER");
		Role r4 = new Role("TEACHER");
		rolesRepository.save(r1);
		rolesRepository.save(r2);
		rolesRepository.save(r3);
		rolesRepository.save(r4);
		
		User u1 = new User("tatajanka@gmail.com","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r3.getId());
		usersRepository.save(u1);
		Caretaker c1 = new Caretaker("Karol", "Pawłowski", "567895436", u1.getId());
		User u2 = new User("szlachataniepracuje@interia.pl","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r3.getId());
		usersRepository.save(u2);
		Caretaker c2 = new Caretaker("Karina", "Zink", "768547567", u2.getId());
		User u3 = new User("BiankaJ@gmail.com","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r3.getId());
		usersRepository.save(u3);
		Caretaker c3 = new Caretaker("Bianka", "Jankowska", "721671575", u3.getId());
		User u4 = new User("DianaW@interia.pl","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r3.getId());
		usersRepository.save(u4);
		Caretaker c4 = new Caretaker("Diana", "Walczak", "231456774", u4.getId());
		User u5 = new User("CecyliaZ@gmail.com","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r3.getId());
		usersRepository.save(u5);
		Caretaker c5 = new Caretaker("Cecylia", "Zakrzewska", "251566757", u5.getId());
		User u6 = new User("MarlenaW@interia.pl","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r3.getId());
		usersRepository.save(u6);
		Caretaker c6 = new Caretaker("Marlena", "Włodarczyk", "109604987", u6.getId());
		User u7 = new User("AlicjaJ@gmail.com","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r3.getId());
		usersRepository.save(u7);
		Caretaker c7 = new Caretaker("Alicja", "Jasińska", "314204895", u7.getId());
		User u8 = new User("OktawiaW@interia.pl","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r3.getId());
		usersRepository.save(u8);
		Caretaker c8 = new Caretaker("Oktawia", "Wasilewska", "640141548", u8.getId());
		User u9 = new User("NorbertL@gmail.com","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.",  r3.getId());
		usersRepository.save(u9);
		Caretaker c9 = new Caretaker("Norbert", "Lis", "72327175",u9.getId());
		User u10 = new User("RomanJ@interia.pl","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r3.getId());
		usersRepository.save(u10);
		Caretaker c10 = new Caretaker("Roman", "Jasiński", "735450527", u10.getId());
		User u11 = new User("KonstantyS@gmail.com","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r3.getId());
		usersRepository.save(u11);
		Caretaker c11 = new Caretaker("Konstanty", "Stępień", "453788747", u11.getId());
		User u12 = new User("MarianT@interia.pl","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r3.getId());
		usersRepository.save(u12);
		Caretaker c12 = new Caretaker("Marian", "Tomaszewski", "945025041", u12.getId());
		
		
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
		
		
		User u13 = new User("fajnygimail@interia.pl", "$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r1.getId());
		usersRepository.save(u13);
		Student s1 = new Student("Szymon", "Suchor", "669666420",  c1.getId(), y1.getId(), u13.getId());
		User u14 = new User("misiaczek1337@gmail.com", "$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r1.getId());
		usersRepository.save(u14);
		Student s2 = new Student("Jan", "Pawłowski", "521371337", c1.getId(), y1.getId(), u14.getId());
		User u15 = new User("quietkid@wp.pl", "$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r1.getId());
		usersRepository.save(u15);
		Student s3 = new Student("Adrzej", "Bryś", "734512378", c1.getId(), y1.getId(), u15.getId());
		User u16 = new User("rosomak@onet.pl", "$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r1.getId());
		usersRepository.save(u16);
		Student s4 = new Student("Damian", "Rosomak", "678345786", c2.getId(), y1.getId(), u16.getId());
		User u17 = new User("AlanS@wp.pl", "$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.",  r1.getId());
		usersRepository.save(u17);
		Student s5 = new Student("Alan", "Szczepański", "673249654", c2.getId(), y1.getId(), u17.getId());
		User u18 = new User("DominikC@wp.pl", "$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r1.getId());
		usersRepository.save(u18);
		Student s6 = new Student("Dominik", "Czarnecki", "135562343",  c3.getId(), y1.getId(), u18.getId());
		User u19 = new User( "LucjanM@wp.pl", "$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.",  r1.getId());
		usersRepository.save(u19);
		Student s7 = new Student("Lucjan", "Mazur", "724571254",c3.getId(), y1.getId(), u19.getId());
		User u20 = new User("DominikT@wp.pl", "$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.",  r1.getId());
		usersRepository.save(u20);
		Student s8 = new Student("Dominik", "Tomaszewski", "715716948", c4.getId(), y2.getId(), u20.getId());
		User u21 = new User("HenrykK@wp.pl", "$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r1.getId());
		usersRepository.save(u21);
		Student s9 = new Student("Henryk", "Kowalczyk", "638575741", c4.getId(), y2.getId(), u21.getId());
		User u22 = new User( "JaroslawB@wp.pl", "$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r1.getId());
		usersRepository.save(u22);
		Student s10 = new Student("Jarosław", "Bąk", "6357498754", c4.getId(), y2.getId(), u22.getId());
		User u99 = new User("KordianO@wp.pl", "$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.",r1.getId());
		usersRepository.save(u99);
		Student s11 = new Student("Kordian", "Ostrowski", "321862184", c3.getId(), y2.getId(), u99.getId());
		studentRepository.save(s11);
		
		User u98 = new User("KrystianL@wp.pl", "$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.",r1.getId());
		usersRepository.save(u98);
		Student s12 = new Student("Krystian", "Lewandowski", "460385021", c5.getId(), y4.getId(), u98.getId());
		studentRepository.save(s12);
		
		
		
//		Student s13 = new Student("Juliusz", "Czerwiński", "204245075", "JuliuszC@wp.pl", "pwd", c5.getId(), y2.getId(), r1.getId());
//		Student s14 = new Student("Fryderyk", "Mazur", "988465198", "FryderykM@wp.pl", "pwd", c6.getId(), y3.getId(), r1.getId());
//		Student s15 = new Student("Emil", "Witkowski", "687548974", "EmilW@wp.pl", "pwd", c6.getId(), y3.getId(), r1.getId());
//		Student s16 = new Student("Mirosław", "Błaszczyk", "747984634", "MiroslawB@wp.pl", "pwd", c6.getId(), y3.getId(), r1.getId());
//		Student s17 = new Student("Klaudiusz", "Piotrowski", "687987894", "KlaudiuszP@wp.pl", "pwd", c8.getId(), y3.getId(), r1.getId());
//		Student s18 = new Student("Aleksander", "Duda", "98798102", "AleksanderD@wp.pl", "pwd", c8.getId(), y4.getId(), r1.getId());
//		Student s19 = new Student("Piotr", "Michalak", "654984654", "PiotrM@wp.pl", "pwd", c8.getId(), y5.getId(), r1.getId());
//		Student s20 = new Student("Faustyna", "Szulc", "673249654", "FaustynaS@wp.pl", "pwd", c8.getId(), y5.getId(), r1.getId());
//		Student s21 = new Student("Izabela", "Krupa", "135562343", "IzabelaK@wp.pl", "pwd", c8.getId(), y5.getId(), r1.getId());
//		Student s22 = new Student("Maria", "Laskowska", "724571254", "MariaL@wp.pl", "pwd", c8.getId(), y6.getId(), r1.getId());
//		Student s23 = new Student("Adrianna", "Piotrowska", "715716948", "AdriannaP@wp.pl", "pwd", c9.getId(), y6.getId(), r1.getId());
//		Student s24 = new Student("Danuta", "Mazur", "638575741", "DanutaM@wp.pl", "pwd", c9.getId(), y6.getId(), r1.getId());
//		Student s25 = new Student("Marysia", "Tomaszewska", "6357498754", "MarysiaT@wp.pl", "pwd", c9.getId(), y5.getId(), r1.getId());
//		Student s26 = new Student("Alana", "Mróz", "321862184", "AlanaM@wp.pl", "pwd", c10.getId(), y4.getId(), r1.getId());
//		Student s27 = new Student("Alicja", "Rutkowska", "460385021", "AlicjaR@wp.pl", "pwd", c10.getId(), y3.getId(), r1.getId());
//		Student s28 = new Student("Beata", "Andrzejewska", "204245075", "BeataA@wp.pl", "pwd", c10.getId(), y6.getId(), r1.getId());
//		Student s29 = new Student("Ada", "Malinowska", "988465198", "AdaM@wp.pl", "pwd", c11.getId(), y4.getId(), r1.getId());
//		Student s30 = new Student("Eliza", "Andrzejewska", "687548974", "ElizaA@wp.pl", "pwd", c12.getId(), y1.getId(), r1.getId());
//		Student s31 = new Student("Jola", "Duda", "747984634", "JolaD@wp.pl", "pwd",c12.getId(), y5.getId(), r1.getId());
//		Student s32 = new Student("Mirosława", "Górecka", "687987894", "MiroslawaG@wp.pl", "pwd", c5.getId(), y5.getId(), r1.getId());
//		Student s33 = new Student("Joanna", "Kalinowska", "98798102", "JoannaK@wp.pl", "pwd", c2.getId(), y5.getId(), r1.getId());
//		Student s34 = new Student("Andżelika", "Borkowska", "654984654", "AndzelikaB@wp.pl", "pwd", c6.getId(), y3.getId(), r1.getId());
////		
		
		 
		studentRepository.save(s1);	
		
		studentRepository.save(s2);	
		studentRepository.save(s3);	
		studentRepository.save(s4);
		studentRepository.save(s5);	
		studentRepository.save(s6);
		studentRepository.save(s7);
		studentRepository.save(s8);
		studentRepository.save(s9);
		studentRepository.save(s10);		
//		studentRepository.save(s11);		
//		studentRepository.save(s12);
//		studentRepository.save(s13);		
//		studentRepository.save(s14);		
//		studentRepository.save(s15);		
//		studentRepository.save(s16);
//		studentRepository.save(s17);		
//		studentRepository.save(s18);		
//		studentRepository.save(s19);		
//		studentRepository.save(s20);
//		studentRepository.save(s21);		
//		studentRepository.save(s22);		
//		studentRepository.save(s23);		
//		studentRepository.save(s24);
//		studentRepository.save(s25);		
//		studentRepository.save(s26);		
//		studentRepository.save(s27);		
//		studentRepository.save(s28);
//		studentRepository.save(s29);		
//		studentRepository.save(s30);		
//		studentRepository.save(s31);		
//		studentRepository.save(s32);
//		studentRepository.save(s33);		
//		studentRepository.save(s34);		
////		
		User u23 = new User( "admin","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.",r2.getId());
		usersRepository.save(u23);		
		Teacher admin = new Teacher("admin", "admin","admin", u23.getId());
		User u24 = new User( "jowita.bak@o2.pl","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r4.getId());
		usersRepository.save(u24);	
		Teacher t1 = new Teacher("Jowita", "Bąk", "645674346", u24.getId()); 					
		User u25 = new User(  "krzysztof.wojtasik@yahoo.com","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r4.getId());
		usersRepository.save(u25);	
		Teacher t2 = new Teacher("Krzysztof", "Wojtasik", "567876541",u25.getId()); 
		User u26 = new User( "grazka.koniczynka@interia.pl","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r4.getId());
		usersRepository.save(u26);	
		Teacher t3 = new Teacher("Grażyna", "Koniczyna", "567435767",u26.getId());	
		User u27 = new User( "AA@yahoo.com","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r4.getId());
		usersRepository.save(u27);	
		Teacher t4 = new Teacher("Anna", "Andrzejczyk", "567890442",u27.getId() );					
		User u28 = new User( "AS@yahoo.com","$2a$12$PRwgF/RveRaIce.BOOBHuufRVg0IYZ485ukahSk3Sx.cRNraRSZU.", r4.getId());
		usersRepository.save(u28);	
		Teacher t5 = new Teacher("Adrian", "Szulc", "357465716",u28.getId() );						
//		Teacher t6 = new Teacher("Edward", "Makowski", "655787621", "EM@yahoo.com","pwd", r4.getId());					
//		Teacher t7 = new Teacher("Gabriel", "Adamski", "876941442", "GA@yahoo.com","pwd", r4.getId());					
//		Teacher t8 = new Teacher("Alek", "Woźniak", "987564354", "AW@yahoo.com","pwd", r4.getId());						
//		Teacher t9 = new Teacher("Ernest", "Wiśniewski", "674236684", "EW@yahoo.com","pwd", r4.getId());					
//		Teacher t10 = new Teacher("Iga", "Zawadzka", "687732146", "IZ@yahoo.com","pwd", r4.getId());						
//		Teacher t11 = new Teacher("Olga", "Kubiak", "321654568", "OK@yahoo.com","pwd", r4.getId());						
//		Teacher t12 = new Teacher("Anita", "Jakubowska", "357498723", "AJ@yahoo.com","pwd", r4.getId());					
//		Teacher t13 = new Teacher("Joanna", "Wasilewska", "562213846", "JW@yahoo.com","pwd", r4.getId());					
//		Teacher t14 = new Teacher("Mirosława", "Rutkowska", "657125222", "MR@yahoo.com","pwd", r4.getId());				
		
		teacherRepository.save(admin);
		teacherRepository.save(t1);
		teacherRepository.save(t2);
		teacherRepository.save(t3);
		teacherRepository.save(t4);
		teacherRepository.save(t5);
//		teacherRepository.save(t6);
//		teacherRepository.save(t7);
//		teacherRepository.save(t8);
//		teacherRepository.save(t9);
//		teacherRepository.save(t10);
//		teacherRepository.save(t11);
//		teacherRepository.save(t12);
//		teacherRepository.save(t13);
//		teacherRepository.save(t14);
		
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
//
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
		
//		CTSMtM mtm31 = new CTSMtM(y1.getId(), su6.getId(), t6.getId());
//		CTSMtM mtm32 = new CTSMtM(y2.getId(), su6.getId(), t6.getId());
//		CTSMtM mtm33 = new CTSMtM(y3.getId(), su6.getId(), t6.getId());
//		CTSMtM mtm34 = new CTSMtM(y4.getId(), su6.getId(), t6.getId());
//		CTSMtM mtm35 = new CTSMtM(y5.getId(), su6.getId(), t6.getId());
//		CTSMtM mtm36 = new CTSMtM(y6.getId(), su6.getId(), t6.getId());
//
//		CTSMtM mtm37 = new CTSMtM(y1.getId(), su10.getId(), t7.getId());
//		CTSMtM mtm38 = new CTSMtM(y2.getId(), su10.getId(), t7.getId());
//		CTSMtM mtm39 = new CTSMtM(y3.getId(), su10.getId(), t7.getId());
//		CTSMtM mtm40 = new CTSMtM(y4.getId(), su7.getId(), t7.getId());
//		CTSMtM mtm41 = new CTSMtM(y5.getId(), su7.getId(), t7.getId());
//		CTSMtM mtm42 = new CTSMtM(y6.getId(), su7.getId(), t7.getId());
//		
//		CTSMtM mtm43 = new CTSMtM(y1.getId(), su12.getId(), t10.getId());
//		CTSMtM mtm44 = new CTSMtM(y2.getId(), su12.getId(), t10.getId());
//		CTSMtM mtm45 = new CTSMtM(y3.getId(), su12.getId(), t10.getId());
//		CTSMtM mtm46 = new CTSMtM(y1.getId(), su13.getId(), t10.getId());
//		CTSMtM mtm47 = new CTSMtM(y2.getId(), su13.getId(), t10.getId());
//		CTSMtM mtm48 = new CTSMtM(y3.getId(), su13.getId(), t10.getId());
//		
//		CTSMtM mtm49 = new CTSMtM(y1.getId(), su18.getId(), t8.getId());
//		CTSMtM mtm50 = new CTSMtM(y2.getId(), su18.getId(), t8.getId());
//		CTSMtM mtm51 = new CTSMtM(y3.getId(), su18.getId(), t8.getId());
//		CTSMtM mtm52 = new CTSMtM(y4.getId(), su8.getId(), t8.getId());
//		CTSMtM mtm53 = new CTSMtM(y5.getId(), su8.getId(), t8.getId());
//		CTSMtM mtm54 = new CTSMtM(y6.getId(), su8.getId(), t8.getId());
//		
//		CTSMtM mtm55 = new CTSMtM(y4.getId(), su16.getId(), t9.getId());
//		CTSMtM mtm56 = new CTSMtM(y5.getId(), su16.getId(), t9.getId());
//		CTSMtM mtm57 = new CTSMtM(y6.getId(), su16.getId(), t9.getId());
//		
//		CTSMtM mtm58 = new CTSMtM(y1.getId(), su9.getId(), t11.getId());
//		CTSMtM mtm59 = new CTSMtM(y2.getId(), su9.getId(), t11.getId());
//		CTSMtM mtm60 = new CTSMtM(y3.getId(), su9.getId(), t11.getId());
//		CTSMtM mtm61 = new CTSMtM(y4.getId(), su9.getId(), t11.getId());
//		CTSMtM mtm62 = new CTSMtM(y5.getId(), su9.getId(), t11.getId());
//		CTSMtM mtm63 = new CTSMtM(y6.getId(), su9.getId(), t11.getId());
//
//		CTSMtM mtm64 = new CTSMtM(y1.getId(), su11.getId(), t12.getId());
//		CTSMtM mtm65 = new CTSMtM(y2.getId(), su11.getId(), t12.getId());
//		CTSMtM mtm66 = new CTSMtM(y3.getId(), su11.getId(), t12.getId());
//		CTSMtM mtm67 = new CTSMtM(y4.getId(), su11.getId(), t12.getId());
//		CTSMtM mtm68 = new CTSMtM(y5.getId(), su11.getId(), t12.getId());
//		CTSMtM mtm69 = new CTSMtM(y6.getId(), su11.getId(), t12.getId());
//		
//		CTSMtM mtm70 = new CTSMtM(y4.getId(), su17.getId(), t13.getId());
//		CTSMtM mtm71 = new CTSMtM(y5.getId(), su17.getId(), t13.getId());
//		CTSMtM mtm72 = new CTSMtM(y6.getId(), su17.getId(), t13.getId());
//
//		CTSMtM mtm73 = new CTSMtM(y1.getId(), su14.getId(), t14.getId());
//		CTSMtM mtm74 = new CTSMtM(y2.getId(), su14.getId(), t14.getId());
//		CTSMtM mtm75 = new CTSMtM(y3.getId(), su14.getId(), t14.getId());
//		CTSMtM mtm76 = new CTSMtM(y4.getId(), su14.getId(), t14.getId());
//		CTSMtM mtm77 = new CTSMtM(y5.getId(), su14.getId(), t14.getId());
//		CTSMtM mtm78 = new CTSMtM(y6.getId(), su14.getId(), t14.getId());
//
//		CTSMtM mtm79 = new CTSMtM(y1.getId(), su15.getId(), t1.getId());
//		CTSMtM mtm80 = new CTSMtM(y2.getId(), su15.getId(), t5.getId());
//		CTSMtM mtm81 = new CTSMtM(y3.getId(), su15.getId(), t14.getId());
//		CTSMtM mtm82 = new CTSMtM(y4.getId(), su15.getId(), t7.getId());
//		CTSMtM mtm83 = new CTSMtM(y5.getId(), su15.getId(), t3.getId());
//		CTSMtM mtm84 = new CTSMtM(y6.getId(), su15.getId(), t10.getId());
//		
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
//		ctsMtMRepository.save(mtm31);
//		ctsMtMRepository.save(mtm32);
//		ctsMtMRepository.save(mtm33);
//		ctsMtMRepository.save(mtm34);
//		ctsMtMRepository.save(mtm35);
//		ctsMtMRepository.save(mtm36);
//		ctsMtMRepository.save(mtm37);
//		ctsMtMRepository.save(mtm38);
//		ctsMtMRepository.save(mtm39);
//		ctsMtMRepository.save(mtm40);
//		ctsMtMRepository.save(mtm41);
//		ctsMtMRepository.save(mtm42);
//		ctsMtMRepository.save(mtm43);
//		ctsMtMRepository.save(mtm44);
//		ctsMtMRepository.save(mtm45);
//		ctsMtMRepository.save(mtm46);
//		ctsMtMRepository.save(mtm47);
//		ctsMtMRepository.save(mtm48);
//		ctsMtMRepository.save(mtm49);
//		ctsMtMRepository.save(mtm50);
//		ctsMtMRepository.save(mtm51);
//		ctsMtMRepository.save(mtm52);
//		ctsMtMRepository.save(mtm53);
//		ctsMtMRepository.save(mtm54);
//		ctsMtMRepository.save(mtm55);
//		ctsMtMRepository.save(mtm56);
//		ctsMtMRepository.save(mtm57);
//		ctsMtMRepository.save(mtm58);
//		ctsMtMRepository.save(mtm59);
//		ctsMtMRepository.save(mtm60);
//		ctsMtMRepository.save(mtm61);
//		ctsMtMRepository.save(mtm62);
//		ctsMtMRepository.save(mtm63);
//		ctsMtMRepository.save(mtm64);
//		ctsMtMRepository.save(mtm65);
//		ctsMtMRepository.save(mtm66);
//		ctsMtMRepository.save(mtm67);
//		ctsMtMRepository.save(mtm68);
//		ctsMtMRepository.save(mtm69);
//		ctsMtMRepository.save(mtm70);
//		ctsMtMRepository.save(mtm71);
//		ctsMtMRepository.save(mtm72);
//		ctsMtMRepository.save(mtm73);
//		ctsMtMRepository.save(mtm74);
//		ctsMtMRepository.save(mtm75);
//		ctsMtMRepository.save(mtm76);
//		ctsMtMRepository.save(mtm77);
//		ctsMtMRepository.save(mtm78);
//		ctsMtMRepository.save(mtm79);
//		ctsMtMRepository.save(mtm80);
//		ctsMtMRepository.save(mtm81);
//		ctsMtMRepository.save(mtm82);
//		ctsMtMRepository.save(mtm83);
//		ctsMtMRepository.save(mtm84);
//		

		Mark m1 = new Mark(4.0, 4, su1.getId(), s1.getId(), "test");
		Mark m2 = new Mark(3.0, 4, su1.getId(), s2.getId(), "test");
		Mark m3 = new Mark(5.0, 4, su1.getId(), s3.getId(), "test");
		Mark m4 = new Mark(2.0, 4, su1.getId(), s4.getId(), "test");
		Mark m5 = new Mark(3.0, 4, su1.getId(), s5.getId(), "test");
		Mark m6 = new Mark(3.5, 4, su1.getId(), s6.getId(), "test");
		Mark m7 = new Mark(2.0, 4, su1.getId(), s7.getId(), "test");
		
		

		markRepository.save(m1);
		markRepository.save(m2);
		markRepository.save(m3);
		markRepository.save(m4);
		markRepository.save(m5);
		markRepository.save(m6);
		markRepository.save(m7);
		
		Mark m12 = new Mark(3.0, 3, su2.getId(), s1.getId(), "Praca domowa");
		Mark m13 = new Mark(1.0, 3, su2.getId(), s2.getId(), "Praca domowa");
		Mark m14 = new Mark(4.0, 3, su2.getId(), s3.getId(), "Praca domowa");

		markRepository.save(m12);
		markRepository.save(m13);
		markRepository.save(m14);
//		
		Remark rk1 = new Remark("BBBBBBB", su2.getId(), s1.getId());
		
		remarksRepository.save(rk1);
////		
////		List<Student> ls = studentRepository.findAllByCaretaker((long) 1);
////		for(Student sss: ls) {
////			System.out.println(sss.toString());
////		}
//		
	}


	

	
}
