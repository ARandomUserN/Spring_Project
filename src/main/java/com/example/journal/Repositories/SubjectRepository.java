package com.example.journal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.journal.Entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
