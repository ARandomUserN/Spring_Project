package com.example.journal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.journal.entities.Mark;

public interface MarkRepository extends JpaRepository<Mark, Long>{

}
