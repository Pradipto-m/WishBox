package com.pradipto.wishbox.repo;

import com.pradipto.wishbox.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<ProductEntity, Integer> {
}
