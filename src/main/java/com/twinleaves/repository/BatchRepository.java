package com.twinleaves.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twinleaves.entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    
}
