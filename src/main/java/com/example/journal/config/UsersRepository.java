package com.example.journal.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UsersRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
	
	@Query("SELECT u.email FROM User u "
			+ "WHERE u.id = ?1")
	String getUserEmail(Long userId);
	
	
}
