package com.tecnica.pruebaInditex.domain.repositoryInterface;

import java.util.Date;

import com.tecnica.pruebaInditex.domain.models.Price;;

public interface PricesRepository {

    public Price findPrice(Date currentDate, int prudictId, int brandId);

}