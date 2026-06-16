package com.example.productservicescapstone.dtos;

import com.example.productservicescapstone.modules.Category;
import com.example.productservicescapstone.modules.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {

    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;


    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setName(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);

        Category prodCategory = new Category();
        product.setCategory(prodCategory);
        prodCategory.setName(category);


        return product;

    }



}
