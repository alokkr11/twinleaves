package com.twinleaves.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.twinleaves.entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {

    // Get latest batch with zero or negative quantity for each GTIN
    @Query("SELECT b FROM Batch b WHERE b.availableQuantity <= 0 AND b.updatedOn = " +
            "(SELECT MAX(b2.updatedOn) FROM Batch b2 WHERE b2.gtin = b.gtin AND b2.availableQuantity <= 0)")
    List<Batch> findLatestBatchWithNonPositiveQuantity();

}
