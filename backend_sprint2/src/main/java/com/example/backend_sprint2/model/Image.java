package com.example.backend_sprint2.model;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "image" )
    private String image;
    @ManyToOne
    @JoinColumn(name = "id_product_racing")
    private ProductRacing productRacing;

    public Image() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductRacing getProductRacing() {
        return productRacing;
    }

    public void setProductRacing(ProductRacing productRacing) {
        this.productRacing = productRacing;
    }
}
