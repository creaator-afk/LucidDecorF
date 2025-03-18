package com.backend.luciddecorf.repositories;

import com.backend.luciddecorf.model.InteriorDesign;

import java.util.List;

public interface ServiceRepositoryCustom {
    List<InteriorDesign> findByParams(
            String title,
            String basePriceMax,
            String basePriceMin,
            String requiresOnsiteVisit,
            String minimumProjectScale,
            String maximumProjectScale
    );
}