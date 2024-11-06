package com.twinleaves.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    @PrePersist
    protected void onCreate() {
        createdOn = LocalDateTime.now();
        updatedOn = createdOn;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedOn = LocalDateTime.now();
    }

}
