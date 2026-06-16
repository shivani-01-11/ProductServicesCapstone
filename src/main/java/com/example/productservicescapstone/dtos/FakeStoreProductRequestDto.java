package com.example.productservicescapstone.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductRequestDto {

    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
