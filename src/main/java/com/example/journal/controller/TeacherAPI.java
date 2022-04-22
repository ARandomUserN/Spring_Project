package com.example.journal.controller;

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

import com.example.journal.entities.Teacher;
import com.example.journal.services.TeacherManager;

@RestController
@RequestMapping("/api/teachers")
public class TeacherAPI {
	private TeacherManager teacherManager;
	
	@Autowired
	public TeacherAPI(TeacherManager teacherManager)
	{
		this.teacherManager = teacherManager;
	}
	
	@GetMapping("/all")
	public Iterable<Teacher> getAll()
	{
		return teacherManager.findAll();
	}
	
	@GetMapping("/id")
	public Optional<Teacher> getById(@RequestParam Long index) {
		return teacherManager.findById(index);
	}
	@GetMapping(value = "/{teacherId}")
	public Optional<Teacher> getId(@PathVariable("teacherId") Long  teacherId) {
		return teacherManager.findById(teacherId);
	}
	
	// TODO teacher/subject/classyear
	
	// TODO teacher/subject/classyear/editmarks(studentID)
	
	@PostMapping("/save")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return teacherManager.save(teacher);
	}

	@PutMapping("/upd")
	public Teacher updateTeacher(@RequestBody Teacher teacher) {
		return teacherManager.save(teacher);
	}

	@DeleteMapping("/del")
	public void deleteTeacher(@RequestParam Long index) {
		teacherManager.deleteById(index);
	}
	
	
}
