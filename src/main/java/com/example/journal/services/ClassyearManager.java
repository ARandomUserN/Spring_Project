package com.example.journal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.journal.entities.Classyear;
import com.example.journal.repositories.ClassyearRepository;

@Service

public class ClassyearManager {

	private final ClassyearRepository classyearRepository;

	@Autowired
	public ClassyearManager(ClassyearRepository classyearRepository) {
		super();
		this.classyearRepository = classyearRepository;
	}

	public Optional<Classyear> findById(Long id) {
		return classyearRepository.findById(id);
	}

	public Iterable<Classyear> findAll() {
		return classyearRepository.findAll();
	}

	public Classyear save(Classyear classyear) {
		return classyearRepository.save(classyear);
	}

	public void deleteById(Long id) {
		classyearRepository.deleteById(id);
	}

	@EventListener(ApplicationReadyEvent.class)

	public void runAtStart() { 

	}

}