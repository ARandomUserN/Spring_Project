package com.example.journal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.journal.entities.Caretaker;

@Repository
public interface CaretakerRepository extends JpaRepository<Caretaker, Long>{

	@Query("SELECT c FROM Caretaker c "
			+ "WHERE c.userId = ?1")
	Caretaker findCaretakerByUserId(Long loggedUserId);

}
