package com.example.journal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.journal.Entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
