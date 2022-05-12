package com.example.journal.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.journal.config.Role;
import com.example.journal.config.RolesRepository;
import com.example.journal.dto.StudentDTO;
import com.example.journal.dto.StudentMarksDTO;
import com.example.journal.dto.StudentRemarksDTO;
import com.example.journal.entities.Caretaker;
import com.example.journal.entities.Classyear;
import com.example.journal.entities.Student;
import com.example.journal.services.ClassyearManager;
import com.example.journal.services.StudentManager;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api/students")
public class StudentAPI {
	private StudentManager studentManager;
	private RolesRepository rolesRepository;
	private Authentication auth;

	private boolean adminAccessPrivilegeCheck(Authentication user) {
		Role admin = rolesRepository.findByRole("ADMIN");
		boolean adminPrivilege = false;
		Collection<GrantedAuthority> userPrivileges = Collections.unmodifiableCollection(auth.getAuthorities());
		for (Iterator<GrantedAuthority> it = userPrivileges.iterator();it.hasNext();){
            if(it.next().toString().equals(admin.getId().toString())) {
            	adminPrivilege = true;
            	break;
            }
        }
		return adminPrivilege;
	}
	
	private boolean accessPrivilegeCheck(String email, Authentication user) {
		Role admin = rolesRepository.findByRole("ADMIN");
		
		boolean adminPrivilege = false;
		Collection<GrantedAuthority> userPrivileges = Collections.unmodifiableCollection(auth.getAuthorities());
		for (Iterator<GrantedAuthority> it = userPrivileges.iterator();it.hasNext();){
            if(it.next().toString().equals(admin.getId().toString())) {
            	adminPrivilege = true;
            	break;
            }
        }
		if(auth.getName().equals(email) || adminPrivilege){
			return true;
		}
		return false;
	}
	@Autowired
	public StudentAPI(StudentManager studentManager,RolesRepository rolesRepository)
	{
		this.studentManager = studentManager;
		this.rolesRepository = rolesRepository;
	}
	
	@GetMapping("/all")
	public List<StudentDTO> getAll()
	{
		return studentManager.findAll();
	}
	
	@GetMapping("/id")
	public StudentDTO getById(@RequestParam Long index) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		StudentDTO dto =  studentManager.findById(index);
		System.out.println(auth.getName() + " " + dto.email() + " " + auth.getAuthorities().toString());
		if(accessPrivilegeCheck(dto.email(), auth)) {
			return dto;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	@GetMapping(value = "/{studentId}")
	public StudentDTO getId(@PathVariable("studentId") Long  studentId) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		StudentDTO dto =  studentManager.findById(studentId);
		System.out.println(auth.getName() + " " + dto.email() + " " + auth.getAuthorities().toString());
		
		if(accessPrivilegeCheck(dto.email(), auth)) {
			return dto;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	@GetMapping("/all/class/classyear")
	public List<Student> getByClassyear(@RequestParam Long index) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		List<StudentMarksDTO> markList = studentManager.findStudentMarks(index);
		if(accessPrivilegeCheck(markList.get(0).email(), auth)) {
			return studentManager.findAllByClass(index);
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		
	}
	@GetMapping("/all/class/{classyearId}")
	public List<Student> getClassyear(@PathVariable("classyearId") Long classyearId) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		List<StudentMarksDTO> markList = studentManager.findStudentMarks(classyearId);
		if(accessPrivilegeCheck(markList.get(0).email(), auth)) {
			return studentManager.findAllByClass(classyearId);
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		
	}
	
	@GetMapping("/id/marks")
	public List<StudentMarksDTO> getStudentMarks(@RequestParam Long id){
		auth = SecurityContextHolder.getContext().getAuthentication();
		List<StudentMarksDTO> markList = studentManager.findStudentMarks(id);
		if(accessPrivilegeCheck(markList.get(0).email(), auth)) {
			return markList;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		
	}
	@GetMapping("/{studentId}/marks")
	public List<StudentMarksDTO> getMarks(@PathVariable("studentId") Long id){
		
		auth = SecurityContextHolder.getContext().getAuthentication();
		List<StudentMarksDTO> markList = studentManager.findStudentMarks(id);
		if(accessPrivilegeCheck(markList.get(0).email(), auth)) {
			return markList;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("/id/remarks")
	public List<StudentRemarksDTO> getStudentRemarks(@RequestParam Long id){
		
		auth = SecurityContextHolder.getContext().getAuthentication();
		List<StudentRemarksDTO> markList = studentManager.findStudentRemarks(id);
		if(accessPrivilegeCheck(markList.get(0).email(), auth)) {
			return markList;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	@GetMapping("/{studentId}/remarks")
	public List<StudentRemarksDTO> getRemarks(@PathVariable("studentId") Long id){
		auth = SecurityContextHolder.getContext().getAuthentication();
		List<StudentRemarksDTO> markList = studentManager.findStudentRemarks(id);
		if(accessPrivilegeCheck(markList.get(0).email(), auth)) {
			return markList;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("/save")
	public List<Classyear> getAllClasses()
	{
		auth = SecurityContextHolder.getContext().getAuthentication();
		if(adminAccessPrivilegeCheck(auth)) {
			return studentManager.getAllClasses();
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	
	// JSON to send from client
		//{
		//	//Student data
		//	"sFName":String,
		//	"sLName":String,
		//	"sPhone":String,
		//	"sEmail":String,
		//	"sPwD":String, // Must be BCrypt
		//	//Caretaker data
		//	"cFName":String,
		//	"cLName":String,
		//	"cPhone":String,
		//	"cEmail":String,
		//	"cPwd":String, // Must be BCrypt
		//	"classyearId":Long
		//}
	@PostMapping("/save")
	public Student addStudent(@RequestBody ObjectNode JSONNode) {
		return studentManager.save(JSONNode.get("sFName").asText(),JSONNode.get("sLName").asText(),
				JSONNode.get("sPhone").asText(), JSONNode.get("sEmail").asText(),JSONNode.get("sPwd").asText(),
				JSONNode.get("cFName").asText(),JSONNode.get("cLName").asText(),
				JSONNode.get("cPhone").asText(),
				JSONNode.get("cEmail").asText(),JSONNode.get("cPwd").asText(),
				JSONNode.get("classyearId").asLong());
	}
	
	
	
	@GetMapping("/upd")
	public List<StudentDTO> getStudentsToUpdate()
	{
		auth = SecurityContextHolder.getContext().getAuthentication();
		if(adminAccessPrivilegeCheck(auth)) {
			return studentManager.findAll();
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		
	}
	@PutMapping("/upd")
	public Student updateStudent(@RequestBody Student student) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		if(adminAccessPrivilegeCheck(auth)) {
			return studentManager.save(student);
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/del")
	public List<StudentDTO> getListOfStudentsToDelete()
	{
		auth = SecurityContextHolder.getContext().getAuthentication();
		if(adminAccessPrivilegeCheck(auth)) {
			return studentManager.findAll();
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		
	} 
	@DeleteMapping("/del")
	public void deleteStudent(@RequestParam Long index) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		if(adminAccessPrivilegeCheck(auth)) {
			studentManager.deleteById(index);
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		
	}
	
	
}
