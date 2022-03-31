package com.example.journal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.journal.Entities.Remark;

public interface RemarksRepository extends JpaRepository<Remark, Long>{

}
