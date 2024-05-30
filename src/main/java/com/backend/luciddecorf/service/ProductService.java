package com.backend.luciddecorf.service;

import com.backend.luciddecorf.model.Category;
import com.backend.luciddecorf.model.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(long productId);
    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product updateProduct(Product product, long productId);
    String deleteProduct(long productId);
    List<Product> getProductsByCategory(String category);
    List<Category> getAllCategories();
}
