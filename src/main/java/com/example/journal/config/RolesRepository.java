package com.example.journal.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RolesRepository extends JpaRepository<Role, Long>{

	@Query("SELECT r FROM Role r "
			+ "WHERE r.role = ?1")
	Role findByRole(String string);

}
