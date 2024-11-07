package com.twinleaves.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.twinleaves.entity.Gtin;

@Repository
public interface GtinRepository extends JpaRepository<Gtin, Long> {

    // Get GTINs with at least one batch having a positive available quantity
    @Query("SELECT DISTINCT g FROM Gtin g JOIN g.batches b WHERE b.availableQuantity > 0")
    List<Gtin> findGtinsWithPositiveQuantity();

}
