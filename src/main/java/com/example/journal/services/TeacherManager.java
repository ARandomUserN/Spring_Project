package com.example.journal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.journal.entities.Teacher;
import com.example.journal.repositories.TeacherRepository;

public class TeacherManager {
	
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherManager(TeacherRepository teacherRepository) {
        super();
        this.teacherRepository = teacherRepository;
    }

    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }

    public Iterable<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteById(Long id) {
    	teacherRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)

      public void runAtStart() { 

      }

}