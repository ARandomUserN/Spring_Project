package com.example.journal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.journal.entities.Remark;

public interface RemarksRepository extends JpaRepository<Remark, Long>{

}
