package com.pradipto.wishbox.controller;

import com.pradipto.wishbox.model.ProductEntity;
import com.pradipto.wishbox.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    ProductServiceImpl services;

    @GetMapping("getAll")
    public ResponseEntity<List<ProductEntity>> getAllProducts () {
        return services.getAllProducts();
    }

    @PostMapping(value = "addProduct",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json")
    public ResponseEntity<String> addProduct (@ModelAttribute @Valid ProductEntity product,
                                              BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Binding result error: " + result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return services.addProduct(product);
    }

    @GetMapping("search/{query}")
    public ResponseEntity<?> searchProduct (@PathVariable String query) {
        return services.searchProduct(query);
    }

    @GetMapping("category/{cat}")
    public ResponseEntity<?> productsByCategory (@PathVariable String cat) {
        return services.productsByCategory(cat);
    }

}
