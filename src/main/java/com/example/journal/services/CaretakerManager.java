package com.example.journal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.journal.entities.Caretaker;
import com.example.journal.repositories.CaretakerRepository;

@Service

public class CaretakerManager {

	private final CaretakerRepository caretakerRepository;

	@Autowired
	public CaretakerManager(CaretakerRepository caretakerRepository) {
		super();
		this.caretakerRepository = caretakerRepository;
	}

	public Optional<Caretaker> findById(Long id) {
		return caretakerRepository.findById(id);
	}

	public Iterable<Caretaker> findAll() {
		return caretakerRepository.findAll();
	}

	public Caretaker save(Caretaker employee) {
		return caretakerRepository.save(employee);
	}

	public void deleteById(Long id) {
		caretakerRepository.deleteById(id);
	}

	@EventListener(ApplicationReadyEvent.class)

	public void runAtStart() { 

	}

}