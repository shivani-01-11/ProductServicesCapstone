package com.example.productservicescapstone.services;

import com.example.productservicescapstone.dtos.FakeStoreProductDto;
import com.example.productservicescapstone.modules.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;


    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductById(long id) {

        FakeStoreProductDto fakestoreProductDto = restTemplate.
                                    getForObject("https://fakestoreapi.com/products/" + id,
                                            FakeStoreProductDto.class);

        return fakestoreProductDto.toProduct();

    }
}
