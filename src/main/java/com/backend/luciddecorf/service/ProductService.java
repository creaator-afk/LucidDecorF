package com.backend.luciddecorf.service;

import com.backend.luciddecorf.exceptions.ProductNotFoundException;
import com.backend.luciddecorf.model.Category;
import com.backend.luciddecorf.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product getSingleProduct(long productId) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(Product product)throws ProductNotFoundException;
    Product updateProduct(Product product, long productId)throws ProductNotFoundException;
    String deleteProduct(long productId);
    List<Product> getProductsByCategory(String category);
    List<Category> getAllCategories();
}
