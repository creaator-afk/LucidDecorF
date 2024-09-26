package com.backend.luciddecorf.repositories;

import com.backend.luciddecorf.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    Product findByTitle(String title);
    Product findByDescription(String description);

    @Query("select p from Product p where p.category.id = :categoryId")
    List<Product> getProductByCategoryId(@Param("categoryId") Long categoryId);

    @Query(value = "select * from product p where p.category_id = :categoryId", nativeQuery = true)
    List<Product> getProductByCategoryIdWithNativeQuery(@Param("categoryId") Long categoryId);

    @Query("select p.title as title, p.id as id from Product p where p.category.id = :categoryId" )
    List<String> getProductsByCategoryIdProjection(@Param("categoryId") Long categoryId);
}
