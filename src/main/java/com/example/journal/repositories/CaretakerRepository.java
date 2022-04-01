package com.example.journal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.journal.Entities.Caretaker;

@Repository
public interface CaretakerRepository extends CrudRepository<Caretaker, Long>{

}