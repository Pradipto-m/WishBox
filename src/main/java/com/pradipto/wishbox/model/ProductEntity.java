package com.pradipto.wishbox.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer productId;
    @Column(nullable = false)
    @NotNull(message = "Field cannot be empty")
    private String productName;
    @Column(nullable = false)
    @NotNull(message = "Field cannot be empty")
    private String seller;
    private String description;
    @Column(nullable = false, columnDefinition = "numeric check (price > 0)")
    @NotNull(message = "Field cannot be empty")
    @Check(constraints = "price > 0")
    private Double price;
    @Column(nullable = false, columnDefinition = "text[] check (array_length(category, 1) > 0)")
    @Size(min = 1, message = "Must mention atleast one category")
    private String[] category;
    @Column(nullable = false)
    @NotNull(message = "Field cannot be empty")
    @URL(message = "Please enter a valid url")
    private String image;
    @Column(nullable = false, columnDefinition = "numeric check (rating < 6 and rating >= 0)")
    @DecimalMax("5.0")
    @DecimalMin("0.0")
    private Float rating;
    @Column(nullable = false)
    @NotNull
    private Integer reviews;

}
