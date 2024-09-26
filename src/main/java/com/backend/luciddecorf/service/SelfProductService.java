package com.backend.luciddecorf.service;

import com.backend.luciddecorf.exceptions.ProductNotFoundException;
import com.backend.luciddecorf.model.Category;
import com.backend.luciddecorf.model.Product;
import com.backend.luciddecorf.repositories.CategoryRepository;
import com.backend.luciddecorf.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private static final Logger log = LoggerFactory.getLogger(SelfProductService.class);
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(long productId) throws ProductNotFoundException{
        Optional<Product> p = productRepository.findById(productId);
        if(p.isPresent()) {
            return p.get();
        }
        throw new ProductNotFoundException("Product not found");
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws ProductNotFoundException{
        Product response = new Product();
        try {
            Category cat = categoryRepository.findByTitle(product.getCategory().getTitle());
            if(cat == null) {
                Category newCat = new Category();
                newCat.setTitle(product.getCategory().getTitle());
                Category newRow = categoryRepository.save(newCat);
                product.setCategory(newRow);
            }else {
                product.setCategory(cat);
            }response = productRepository.save(product);
        }catch (Exception e) {
            throw new ProductNotFoundException("Product not found");
        }
        return response;
    }

    @Override
    public Product updateProduct(Product product, long productId) throws ProductNotFoundException{
        Optional<Product> p = productRepository.findById(product.getId());
        p.get();
        if(!p.isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }
        Product existingInDbProd = p.get();
        if (product.getTitle() != null){
            existingInDbProd.setTitle(product.getTitle());
        }
        if(product.getDescription() != null){
            existingInDbProd.setDescription(product.getDescription());
        }
        return productRepository.save(existingInDbProd);
    }


    @Override
    public String deleteProduct(long productId) {
        return "";
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }
}
