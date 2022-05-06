package com.example.journal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.journal.entities.Role;

public interface RolesRepository extends JpaRepository<Role, Long>{

}
