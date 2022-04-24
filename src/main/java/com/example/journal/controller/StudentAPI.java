package com.example.journal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.journal.dto.StudentDTO;
import com.example.journal.entities.Student;
import com.example.journal.services.StudentManager;

@RestController
@RequestMapping("/api/students")
public class StudentAPI {
	private StudentManager studentManager;
	
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
		return studentManager.findById(index);
	}
	@GetMapping(value = "/{studentId}")
	public StudentDTO getId(@PathVariable("studentId") Long  studentId) {
		return studentManager.findById(studentId);
	}
	@GetMapping("/all/class/classyear")
	public List<Student> getByClassyear(@RequestParam Long index) {
		return studentManager.findAllByClass(index);
	}
	@GetMapping("/all/class/{classyearId}")
	public List<Student> getClassyear(@PathVariable("classyearId") Long classyearId) {
		return studentManager.findAllByClass(classyearId);
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
