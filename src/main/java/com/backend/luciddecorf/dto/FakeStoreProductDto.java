package com.backend.luciddecorf.dto;

import com.backend.luciddecorf.model.Category;
import com.backend.luciddecorf.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);
        Category category = new Category();
        category.setTitle(this.category);
        return product;
    }

}
