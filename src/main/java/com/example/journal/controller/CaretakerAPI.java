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

import com.example.journal.entities.Caretaker;
import com.example.journal.services.CaretakerManager;

@RestController
@RequestMapping("/api/caretakers")
public class CaretakerAPI {

	private CaretakerManager caretakerManager;

	@Autowired
	public CaretakerAPI(CaretakerManager caretakerManager) {
		super();
		this.caretakerManager = caretakerManager;
	}


	@GetMapping("/all")
	public Iterable<Caretaker> getAll() {
		return caretakerManager.findAll();
	}

	@GetMapping("/id")
	public Optional<Caretaker> getById(@RequestParam Long index) {
		return caretakerManager.findById(index);
	}
	@GetMapping(value = "/{caretakerId}")
	public Optional<Caretaker> getId(@PathVariable("caretakerId") Long  caretakerId) {
		return caretakerManager.findById(caretakerId);
	}
	@PostMapping("/save")
	public Caretaker addCaretaker(@RequestBody Caretaker caretaker) {
		return caretakerManager.save(caretaker);
	}

	@PutMapping("/upd")
	public Caretaker updateCaretaker(@RequestBody Caretaker caretaker) {
		return caretakerManager.save(caretaker);
	}

	@DeleteMapping("/del")
	public void deleteCaretaker(@RequestParam Long index) {
		caretakerManager.deleteById(index);
	}



}