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

import com.example.journal.entities.Subject;
import com.example.journal.services.SubjectManager;

@RestController
@RequestMapping("/api/subjects")
public class SubjectAPI {
	private SubjectManager subjectManager;
	
	@Autowired
	public SubjectAPI(SubjectManager subjectManager)
	{
		this.subjectManager = subjectManager;
	}
	
	@GetMapping("/all")
	public Iterable<Subject> getAll()
	{
		return subjectManager.findAll();
	}
	
	@GetMapping("/id")
	public Optional<Subject> getById(@RequestParam Long index) {
		return subjectManager.findById(index);
	}
	@GetMapping(value = "/{subjectId}")
	public Optional<Subject> getId(@PathVariable("subjectId") Long  subjectId) {
		return subjectManager.findById(subjectId);
	}
	@PostMapping("/save")
	public Subject addSubject(@RequestBody Subject subject) {
		return subjectManager.save(subject);
	}

	@PutMapping("/upd")
	public Subject updateSubject(@RequestBody Subject subject) {
		return subjectManager.save(subject);
	}

	@DeleteMapping("/del")
	public void deleteSubject(@RequestParam Long index) {
		subjectManager.deleteById(index);
	}
	
	
}
