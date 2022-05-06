package com.example.journal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.journal.config.User;


public interface UsersRepository extends JpaRepository<User, Long>{

}
