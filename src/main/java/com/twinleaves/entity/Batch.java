package com.twinleaves.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Batch extends BaseEntity {

    private int mrp;
    private int sp;
    private int purchasePrice;
    private int availableQuantity;

    @ManyToOne
    @JoinColumn(name = "gtinId", nullable = false)
    private Gtin gtin;
}
