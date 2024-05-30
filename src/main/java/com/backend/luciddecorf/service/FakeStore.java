package com.backend.luciddecorf.service;

import com.backend.luciddecorf.dto.FakeStoreProductDto;
import com.backend.luciddecorf.model.Category;
import com.backend.luciddecorf.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStore implements ProductService{

    private final RestTemplate restTemplate;

    public FakeStore(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(long productId) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class
        );
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
            List<Product> lst = new ArrayList<>();;
            FakeStoreProductDto[] fakeStoreProductDto = restTemplate.getForObject(
                    "https://fakestoreapi.com/products", FakeStoreProductDto[].class
            );
            List<FakeStoreProductDto> fakeStoreProductDtoList = new ArrayList<>(Arrays.asList(fakeStoreProductDto));

            for (FakeStoreProductDto fakeStoreProductDto1 : fakeStoreProductDtoList) {
                lst.add(fakeStoreProductDto1.toProduct());
            }

        return List.of();
    }

    @Override
    public Product addProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setCategory(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setImage(product.getDescription());

        FakeStoreProductDto response = restTemplate.postForObject(
                "http://fakestoreapi.com/products",fakeStoreProductDto,FakeStoreProductDto.class
        );

        return response.toProduct();
    }

    @Override
    public Product updateProduct(Product product, long productId) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setImage(product.getDescription());
        restTemplate.put(
                "http://fakestoreapi.com/products/" + productId, fakeStoreProductDto
        );
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public String deleteProduct(long productId) {
        restTemplate.delete("http://fakestoreapi.com/products/" + productId);
        return "product with id "+productId+ " was deleted";
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> lstnew = new ArrayList<>();
        FakeStoreProductDto[] fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreProductDto[].class
        );
        List<FakeStoreProductDto> fakeStoreProductDtoList = new ArrayList<>(Arrays.asList(fakeStoreProductDto));

        for (FakeStoreProductDto fakeStoreProductDto1 : fakeStoreProductDtoList) {
            if (fakeStoreProductDto1.getCategory().equals(category)) {
                lstnew.add(fakeStoreProductDto1.toProduct());
            }
        }
        return lstnew;
    }

    @Override
    public List<Category> getAllCategories() {
        String[] fakeStoreCategories = restTemplate.getForObject(
                "https://fakestoreapi.com/categories", String[].class
        );
        List<Category> lst = new ArrayList<>();

        long id = 1L;
        for (String fakeStoreCategory : fakeStoreCategories) {
            lst.add(new Category(id,fakeStoreCategory));
        }
        return lst;
    }
}
