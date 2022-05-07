package com.example.journal.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
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

import com.example.journal.dto.StudentDTO;
import com.example.journal.dto.StudentMarksDTO;
import com.example.journal.dto.StudentRemarksDTO;
import com.example.journal.entities.Student;
import com.example.journal.services.StudentManager;

@RestController
@RequestMapping("/api/students")
public class StudentAPI {
	private StudentManager studentManager;

	private Authentication auth;

		
	@Autowired
	public StudentAPI(StudentManager studentManager)
	{
		this.studentManager = studentManager;
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
		System.out.println(auth.getName() + " " + dto.email());
		if(auth.getName().equals(dto.email())) {
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
		System.out.println(auth.getName() + " " + dto.email());
		if(auth.getName().equals(dto.email())) {
			return dto;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	@GetMapping("/all/class/classyear")
	public List<Student> getByClassyear(@RequestParam Long index) {
		return studentManager.findAllByClass(index);
	}
	@GetMapping("/all/class/{classyearId}")
	public List<Student> getClassyear(@PathVariable("classyearId") Long classyearId) {
		return studentManager.findAllByClass(classyearId);
	}
	
	@GetMapping("/id/marks")
	public List<StudentMarksDTO> getStudentMarks(@RequestParam Long id){
		auth = SecurityContextHolder.getContext().getAuthentication();
		List<StudentMarksDTO> markList = studentManager.findStudentMarks(id);
		if(auth.getName().equals(markList.get(0).email())) {
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
		if(auth.getName().equals(markList.get(0).email())) {
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
		if(auth.getName().equals(markList.get(0).email())) {
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
		if(auth.getName().equals(markList.get(0).email())) {
			return markList;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("/save")
	public void getStudentRelevantInfo()
	{
		
	}
	@PostMapping("/save")
	public Student addStudent(@RequestBody Student student) {
		return studentManager.save(student);
	}

	@PutMapping("/upd")
	public Student updateStudent(@RequestBody Student student) {
		return studentManager.save(student);
	}

	@DeleteMapping("/del")
	public void deleteStudent(@RequestParam Long index) {
		studentManager.deleteById(index);
	}
	
	
}
