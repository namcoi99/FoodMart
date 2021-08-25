package com.springboot.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PRODUCT", uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class AppProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long productID;
    private String name;
    private String category;
    private Long quantity;
    private Long sold;
    private Long price;

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    private String imageUrl;

    public AppProduct() {}

    public AppProduct(Long productID, String name, String category, Long quantity, Long sold, Long price) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.sold = sold;
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getSold() {
        return sold;
    }

    public void setSold(Long sold) {
        this.sold = sold;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", sold=" + sold +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
