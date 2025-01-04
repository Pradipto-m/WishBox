package com.pradipto.wishbox.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "products")
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
