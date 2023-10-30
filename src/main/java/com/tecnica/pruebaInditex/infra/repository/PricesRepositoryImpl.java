package com.tecnica.pruebaInditex.infra.repository;

import com.tecnica.pruebaInditex.domain.models.Price;
import com.tecnica.pruebaInditex.domain.repositoryInterface.PricesRepository;
import com.tecnica.pruebaInditex.infra.repository.DBmodels.PriceEntity;
import com.tecnica.pruebaInditex.infra.repository.DBmodels.PriceMapper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class PricesRepositoryImpl implements PricesRepository {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PriceMapper priceMapper;

    @Override
    @Transactional
    public Price findPrice(Date appDate, int productId, int brandId) {
        
        TypedQuery<PriceEntity> query = entityManager.createQuery(
                "FROM PriceEntity p WHERE p.productId = :productId AND p.brandId = :brandId AND:appDate BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC",
                PriceEntity.class);
        query.setParameter("appDate", appDate);
        query.setParameter("productId", productId);
        query.setParameter("brandId", brandId);
        
        PriceEntity dbPrice = query.setMaxResults(1).getResultStream().findFirst().orElse(null);

        return priceMapper.priceEntityToPrice(dbPrice);

    }

}