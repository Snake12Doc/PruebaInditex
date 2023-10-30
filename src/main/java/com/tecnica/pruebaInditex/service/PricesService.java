package com.tecnica.pruebaInditex.service;

import java.util.Date;

import com.tecnica.pruebaInditex.domain.models.Price;

public interface PricesService {

    public Price findPrice(Date currentDate, int prudictId, int brandId);

}
