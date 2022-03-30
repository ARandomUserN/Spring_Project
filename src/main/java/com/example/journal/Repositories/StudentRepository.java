package com.example.journal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.journal.Entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
