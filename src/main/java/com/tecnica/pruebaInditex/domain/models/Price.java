package com.tecnica.pruebaInditex.domain.models;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {

    private double price;
    private int productId;
    private int brandId;
    private Date startDate;
    private Date endDate;
    private int fee;
    private String currency;

}