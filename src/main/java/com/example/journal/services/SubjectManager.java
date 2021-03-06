package com.example.journal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.journal.entities.Subject;
import com.example.journal.repositories.SubjectRepository;


@Service
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
	
	public List<Subject> findByClassyear(Long classyearId){
		return subjectRepository.findByClassyear(classyearId);
	}
	public List<Subject> findByTeacher(Long teacherId){
		return subjectRepository.findByTeacher(teacherId);
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