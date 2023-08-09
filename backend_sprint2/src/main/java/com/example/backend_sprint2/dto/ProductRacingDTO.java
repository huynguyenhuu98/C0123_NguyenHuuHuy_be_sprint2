package com.example.backend_sprint2.dto;

import com.example.backend_sprint2.model.ProductType;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class ProductRacingDTO {
    private Long id;
    @NotBlank
    private String nameRacing;
    @NotBlank
    private Long price;
    @NotBlank
    private String note;
    @NotBlank
    private Integer quantity;
    private String images;
    private LocalDateTime createDate;
    @NotBlank
    private ProductType productType;

    public ProductRacingDTO() {
    }

    public ProductRacingDTO(Long id, String nameRacing, Long price, String note, Integer quantity, String images, LocalDateTime createDate, ProductType productType) {
        this.id = id;
        this.nameRacing = nameRacing;
        this.price = price;
        this.note = note;
        this.quantity = quantity;
        this.images = images;
        this.createDate = createDate;
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRacing() {
        return nameRacing;
    }

    public void setNameRacing(String nameRacing) {
        this.nameRacing = nameRacing;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
