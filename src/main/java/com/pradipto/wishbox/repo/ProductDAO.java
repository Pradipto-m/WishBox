package com.pradipto.wishbox.repo;

import com.pradipto.wishbox.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<ProductEntity, Integer> {

    @Query("select p from ProductEntity p where " +
            "lower(p.productName) like lower(concat('%', :query, '%')) or " +
            "lower(p.seller) like lower(concat('%', :query, '%')) or " +
            "lower(p.description) like lower(concat('%', :query, '%'))")
    public List<ProductEntity> searchProducts (String query);

    @Query(value = "select * from products p where exists " +
            "(select 1 from unnest(p.category) as c " +
            "where c ilike '%' || :cat || '%')",
            nativeQuery = true)
    public List<ProductEntity> sortByCategory (String cat);

}
