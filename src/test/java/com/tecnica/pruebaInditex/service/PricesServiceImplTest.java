package com.tecnica.pruebaInditex.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tecnica.pruebaInditex.domain.models.Price;
import com.tecnica.pruebaInditex.domain.repositoryInterface.PricesRepository;

@ExtendWith(MockitoExtension.class)
public class PricesServiceImplTest {

    @InjectMocks
    private PricesServiceImpl pricesService;

    @Mock
    private PricesRepository pricesRepository;

    @Test
    public void findPrice_whenRepositoryOK_ReturnOK() {
        Date applicationDate = new Date();
        Date startDate = new Date();
        Date endDate = new Date();
        int productId = 35455;
        int brandId = 1;
        double price = 25.50;
        int fee = 2;
        Price pr = Price.builder().brandId(brandId).currency("EUR").endDate(endDate).startDate(startDate)
                .productId(productId).price(price).fee(fee).build();

        when(pricesRepository.findPrice(applicationDate, productId, brandId)).thenReturn(pr);

        Price result = pricesService.findPrice(applicationDate, productId, brandId);

        assertNotNull(result);
        assertSame(pr, result);
        verify(pricesRepository, times(1)).findPrice(applicationDate, productId, brandId);
        verifyNoMoreInteractions(pricesRepository);

    }

    @Test
    public void findPrice_whenRepositoryKo_ReturnKo() {
        Date applicationDate = new Date();
        int productId = 35455;
        int brandId = 1;

        when(pricesRepository.findPrice(applicationDate, productId, brandId)).thenReturn(null);

        Price result = pricesService.findPrice(applicationDate, productId, brandId);

        assertNull(result);
        verify(pricesRepository, times(1)).findPrice(applicationDate, productId, brandId);
        verifyNoMoreInteractions(pricesRepository);

    }

}
