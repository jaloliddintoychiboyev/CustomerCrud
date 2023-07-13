package com.example.customercrud.service;

import com.example.customercrud.dto.ApiResponse;
import com.example.customercrud.dto.CardDto;
import com.example.customercrud.dto.ProductDto;
import com.example.customercrud.entity.Card;
import com.example.customercrud.entity.Product;
import com.example.customercrud.repository.CardRepository;
import com.example.customercrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> productList() {
        List<Product> all = productRepository.findAll();
        return all;
    }

    public Page<Product> productPage(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Product> all = productRepository.findAll(pageable);
        return all;
    }

    public Product getProduct(Integer id) {
        Product product = productRepository.findById(id).get();
        return product;
    }

    public ApiResponse saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
        ApiResponse apiResponse = new ApiResponse("Successful Saved Product!", true);
        return apiResponse;
    }

    public ApiResponse updateProduct(Integer id, ProductDto productDto) {
        boolean b = productRepository.existsById(id);
        if (b) {
            Product product = productRepository.findById(id).get();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            productRepository.save(product);
            ApiResponse response = new ApiResponse("Successful Update Product", true);
            return response;
        } else {
            ApiResponse response = new ApiResponse("Id Not Found!", false);
            return response;
        }
    }

    public ApiResponse deleteProductById(Integer id) {
        boolean b = productRepository.existsById(id);
        if (b) {
            productRepository.deleteById(id);
            ApiResponse response = new ApiResponse("Successful Delete Product!", true);
            return response;
        } else {
            ApiResponse response = new ApiResponse("Id Not found!", false);
            return response;
        }
    }
}
