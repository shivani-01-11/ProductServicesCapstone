package com.example.productservicescapstone.controllers;

import com.example.productservicescapstone.dtos.ProductResponseDto;
import com.example.productservicescapstone.modules.Product;
import com.example.productservicescapstone.services.FakeStoreProductService;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    FakeStoreProductService fakeStoreProductService;

    public ProductController(FakeStoreProductService fakeStoreProductService) {
        this.fakeStoreProductService = fakeStoreProductService;
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable long id){

        Product product = fakeStoreProductService.getProductById(id);
        ProductResponseDto productResponseDto = ProductResponseDto.from(product);

        ResponseEntity<ProductResponseDto> responseEntity =
                new ResponseEntity<>(productResponseDto, HttpStatus.FORBIDDEN);
        return responseEntity;



//    @GetMapping("/products/{id}")
//    public ProductResponseDto getProductById(@PathVariable long id  ){
//        ProductResponseDto dummyProductResponseDto = new ProductResponseDto();
//        dummyProductResponseDto.setId(1);
//        dummyProductResponseDto.setName("Product " + id);
//        dummyProductResponseDto.setDescription("Product Description");
//        dummyProductResponseDto.setPrice(11.23);
//        dummyProductResponseDto.setImageUrl("https://dummy.image");
//
//        return dummyProductResponseDto;
    }
}
