package com.pradipto.wishbox.controller;

import com.pradipto.wishbox.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    ProductService services;

    @GetMapping("getAll")
    public String getAllProducts (){
        return "All Products!";
    }

}
