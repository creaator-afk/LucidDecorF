package com.backend.luciddecorf.service;

import com.backend.luciddecorf.dto.FakeStoreProductDto;
import com.backend.luciddecorf.exceptions.ProductNotFoundException;
import com.backend.luciddecorf.model.Category;
import com.backend.luciddecorf.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate = new RestTemplate();

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(long productId) throws ProductNotFoundException {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);

        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product not found" + productId);
        }
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        FakeStoreProductDto[] res = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreProductDto[].class
        );
        for(FakeStoreProductDto fakeStoreProductDto : res){
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setCategory(product.getCategory().getTitle());
        fakeStoreProductDto.setImage(product.getImageUrl());

        FakeStoreProductDto response = restTemplate.postForObject(
                "http://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class
        );
        return response.toProduct();
    }

    @Override
    public Product updateProduct(Product product, long productId) throws ProductNotFoundException {
        return null;
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
