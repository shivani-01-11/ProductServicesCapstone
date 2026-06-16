package com.example.productservicescapstone.controllers;

import com.example.productservicescapstone.dtos.CreateFakeStoreProductDto;
import com.example.productservicescapstone.dtos.ErrorDto;
import com.example.productservicescapstone.dtos.FakeStoreProductRequestDto;
import com.example.productservicescapstone.dtos.ProductResponseDto;
import com.example.productservicescapstone.exceptions.ProductNotFoundException;
import com.example.productservicescapstone.modules.Product;
import com.example.productservicescapstone.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

  ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable long id) throws ProductNotFoundException {

        Product product = productService.getProductById(id);
        ProductResponseDto productResponseDto = ProductResponseDto.from(product);

        ResponseEntity<ProductResponseDto> responseEntity =
                new ResponseEntity<>(productResponseDto, HttpStatus.FORBIDDEN);
        return responseEntity;

    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts(){
        List<Product> products = productService.getAllProducts();

        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for(Product product: products){
            ProductResponseDto productResponseDto = new ProductResponseDto();
            productResponseDtos.add(productResponseDto.from(product));

        }
        return productResponseDtos;

    }

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody CreateFakeStoreProductDto createFakeStoreProductDto){

        Product product = productService.createProduct(
                createFakeStoreProductDto.getName(),
                createFakeStoreProductDto.getDescription(),
                createFakeStoreProductDto.getPrice(),
                createFakeStoreProductDto.getImageUrl(),
                createFakeStoreProductDto.getCategory()
        );

        ProductResponseDto productResponseDto = ProductResponseDto.from(product);

     return productResponseDto;

    }

//    @ExceptionHandler(NullPointerException.class)
//    public ErrorDto handleNullPointerExceptions(){
//        ErrorDto errorDto = new ErrorDto();
//
//        errorDto.setStatus("Failure");
//        errorDto.setMessage("Null PointerException occured");
//
//        return errorDto;
//    }

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
