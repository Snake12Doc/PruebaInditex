package com.tecnica.pruebaInditex.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnica.pruebaInditex.domain.repositoryInterface.PricesRepository;
import com.tecnica.pruebaInditex.domain.models.Price;

@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    private PricesRepository pricesRepository;

    @Override
    public Price findPrice(Date currentDate, int productId, int brandId) {

        return pricesRepository.findPrice(currentDate, productId, brandId);

    }
}
