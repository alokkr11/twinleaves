package com.twinleaves.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twinleaves.entity.Gtin;

@Repository
public interface GtinRepository extends JpaRepository<Gtin, Long> {
    
}
