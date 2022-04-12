package com.example.journal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.journal.entities.Subject;
import com.example.journal.repositories.SubjectRepository;

public class SubjectManager {

	private final SubjectRepository subjectRepository;

	@Autowired
	public SubjectManager(SubjectRepository subjectRepository) {
		super();
		this.subjectRepository = subjectRepository;
	}

	public Optional<Subject> findById(Long id) {
		return subjectRepository.findById(id);
	}

	public Iterable<Subject> findAll() {
		return subjectRepository.findAll();
	}

	public Subject save(Subject subject) {
		return subjectRepository.save(subject);
	}

	public void deleteById(Long id) {
		subjectRepository.deleteById(id);
	}

	@EventListener(ApplicationReadyEvent.class)

	public void runAtStart() { 

	}

}