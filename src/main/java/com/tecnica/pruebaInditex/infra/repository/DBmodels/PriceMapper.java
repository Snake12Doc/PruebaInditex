package com.tecnica.pruebaInditex.infra.repository.DBmodels;

import org.springframework.stereotype.Component;

import com.tecnica.pruebaInditex.domain.models.Price;

//es lo mismo que servicio por no es un servicio
@Component
public class PriceMapper {

    public Price priceEntityToPrice(PriceEntity dbPrice) {
        if (dbPrice == null) {
            return null;
        }

        return Price.builder()
                .brandId(dbPrice.getBrandId())
                .productId(dbPrice.getProductId())
                .currency(dbPrice.getCurr())
                .endDate(dbPrice.getEndDate())
                .startDate(dbPrice.getStartDate())
                .fee(dbPrice.getPriceList())
                .price(dbPrice.getPrice())
            .build();
    }

}
