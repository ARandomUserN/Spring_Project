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

import com.example.journal.entities.Classyear;
import com.example.journal.services.ClassyearManager;

@RestController
@RequestMapping("/api/classyears")
public class ClassyearAPI {
	private ClassyearManager classyearManager;
	
	@Autowired
	public ClassyearAPI(ClassyearManager classyearManager)
	{
		this.classyearManager = classyearManager;
	}
	
	@GetMapping("/all")
	public Iterable<Classyear> getAll()
	{
		return classyearManager.findAll();
	}
	
	@GetMapping("/all/subject/subjectId")
	public List<Classyear> getBySubjectId(@RequestParam Long index) {
		return classyearManager.findAllBySubject(index);
	}
	@GetMapping(value = "/all/subject/{subjectId}")
	public List<Classyear> getSubjectId(@PathVariable("subjectId") Long  subjectId) {
		return classyearManager.findAllBySubject(subjectId);
	}
	@GetMapping("/id")
	public Optional<Classyear> getById(@RequestParam Long index) {
		return classyearManager.findById(index);
	}
	@GetMapping(value = "/{classyearId}")
	public Optional<Classyear> getId(@PathVariable("classyearId") Long  classyearId) {
		return classyearManager.findById(classyearId);
	}
	@PostMapping("/save")
	public Classyear addClassyear(@RequestBody Classyear classyear) {
		return classyearManager.save(classyear);
	}

	@PutMapping("/upd")
	public Classyear updateClassyear(@RequestBody Classyear classyear) {
		return classyearManager.save(classyear);
	}

	@DeleteMapping("/del")
	public void deleteClassyear(@RequestParam Long index) {
		classyearManager.deleteById(index);
	}
	
	
}
