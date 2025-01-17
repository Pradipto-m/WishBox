package com.pradipto.wishbox.service;

import com.pradipto.wishbox.model.ProductEntity;
import com.pradipto.wishbox.repo.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDao;

    @Override
    public ResponseEntity<List<ProductEntity>> getAllProducts () {
        try {
            return new ResponseEntity<>(productDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> addProduct (ProductEntity product) {
        try {
            productDao.save(product);
            return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Service error: "  + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> searchProduct (String query) {
        try {
            List<ProductEntity> productList = productDao.searchProducts(query);
            if (productList.isEmpty())
                return new ResponseEntity<>("Related products not found", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Service error: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> productsByCategory (String cat) {
        try {
            if (productDao.sortByCategory(cat).isEmpty())
                return new ResponseEntity<>("Category doesn't exist", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(productDao.sortByCategory(cat), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Service error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        try {
            return new ResponseEntity<>(productDao.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Service error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
