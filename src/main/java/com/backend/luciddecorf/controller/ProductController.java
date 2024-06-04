package com.backend.luciddecorf.controller;

import com.backend.luciddecorf.exceptions.ProductNotFoundException;
import com.backend.luciddecorf.model.Category;
import com.backend.luciddecorf.model.Product;
import com.backend.luciddecorf.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) throws ProductNotFoundException {
        Product currentProduct = productService.getSingleProduct(id);
        ResponseEntity<Product> res = new ResponseEntity<>(
                currentProduct, HttpStatus.OK
        );
        return res;
    }

    @GetMapping("/products/categories")
    public List<Category> getAllCategories() {
        return productService.getAllCategories();
    }

    @GetMapping("/health")
    public ResponseEntity<String> checkHealthOfTheService() {
        return new ResponseEntity<>("Backend application server is running perfectly fine",HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product)throws ProductNotFoundException {
        Product postRequestResponse = productService.createProduct(product);
        return new ResponseEntity<>(postRequestResponse, HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) throws ProductNotFoundException {
        Product res = productService.updateProduct(product, id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/products/category/{categoryName}")
    public List<Product> getProductsByCategory(@PathVariable String categoryName) {
        return productService.getProductsByCategory(categoryName);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }



}
