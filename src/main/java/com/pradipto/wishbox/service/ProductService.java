package com.pradipto.wishbox.service;

import com.pradipto.wishbox.model.ProductEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<List<ProductEntity>> getAllProducts ();

    ResponseEntity<String> addProduct (ProductEntity product);

    ResponseEntity<?> searchProduct (String query);

    ResponseEntity<?> productsByCategory (String cat);

    ResponseEntity<?> getById (Integer id);

}
