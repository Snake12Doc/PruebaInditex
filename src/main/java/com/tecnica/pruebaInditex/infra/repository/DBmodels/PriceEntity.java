package com.tecnica.pruebaInditex.infra.repository.DBmodels;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Data
@Entity
@Table(name = "price")
public class PriceEntity {

    @Id
    @Column()
    private int id;

    @Column()
    private int productId;

    @Column()
    private int brandId;

    @Column()
    private int priceList;

    @Column()
    private Timestamp startDate;

    @Column()
    private Timestamp endDate;

    @Column()
    private String curr;

    @Column()
    private double price;

    @Column()
    private int priority;

}