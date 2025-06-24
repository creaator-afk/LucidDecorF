package com.backend.luciddecorf.repositories.impl;

import com.backend.luciddecorf.model.InteriorDesign;
import com.backend.luciddecorf.repositories.ServiceRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceRepositoryImpl implements ServiceRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<InteriorDesign> findByParams(String title, String basePriceMax, String basePriceMin, String requiresOnsiteVisit, String minimumProjectScale, String maximumProjectScale) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<InteriorDesign> query = cb.createQuery(InteriorDesign.class);
        Root<InteriorDesign> root = query.from(InteriorDesign.class);

        List<Predicate> predicates = new ArrayList<>();

        if (title != null && !title.isEmpty()) {
            predicates.add(cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%"));
        }
        if (basePriceMax != null && !basePriceMax.isEmpty()) {
            predicates.add(cb.lessThanOrEqualTo(root.get("basePrice"), new BigDecimal(basePriceMax)));
        }
        if (basePriceMin != null && !basePriceMin.isEmpty()) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("basePrice"), new BigDecimal(basePriceMin)));
        }
        if (requiresOnsiteVisit != null && !requiresOnsiteVisit.isEmpty()) {
            predicates.add(cb.equal(root.get("requiresOnSiteVisit"), Boolean.parseBoolean(requiresOnsiteVisit)));
        }
        if (minimumProjectScale != null && !minimumProjectScale.isEmpty()) {
            predicates.add(cb.like(cb.lower(root.get("minimumProjectScale")), "%" + minimumProjectScale.toLowerCase() + "%"));
        }
        if (maximumProjectScale != null && !maximumProjectScale.isEmpty()) {
            System.out.println("Maximum project scale: " + maximumProjectScale);
            predicates.add(cb.like(cb.lower(root.get("maximumProjectScale")), "%" + maximumProjectScale.toLowerCase() + "%"));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}