package com.example.journal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.journal.Entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	

}
