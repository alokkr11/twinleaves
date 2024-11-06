package com.twinleaves.entity;

import lombok.Data;

import jakarta.persistence.Entity;

@Data
@Entity
public class Product extends BaseEntity {

    private String productName;

}

