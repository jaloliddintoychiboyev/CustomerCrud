package com.example.customercrud.controller;

import com.example.customercrud.dto.ApiResponse;
import com.example.customercrud.dto.ProductDto;
import com.example.customercrud.entity.Product;
import com.example.customercrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public List<Product> productList(){
        List<Product> products = productService.productList();
        return products;
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id){
        Product product = productService.getProduct(id);
        return product;
    }
    @PostMapping
    public ApiResponse saveProduct(@RequestBody ProductDto productDto){
        ApiResponse saveProduct = productService.saveProduct(productDto);
        return saveProduct;
    }
    @GetMapping("/productPage/{page}")
    public Page<Product> productPage(@PathVariable Integer page){
        Page<Product> products = productService.productPage(page);
        return products;
    }
    @PutMapping("/{id}")
    public ApiResponse updateProduct(@PathVariable Integer id,@RequestBody ProductDto productDto){
        ApiResponse response = productService.updateProduct(id, productDto);
        return response;
    }
    @DeleteMapping("/{id}")
    public ApiResponse deleteProduct(@PathVariable Integer id){
        ApiResponse response = productService.deleteProductById(id);
        return response;
    }
}
