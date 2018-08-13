package com.nau.shop.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AbstractEntity {

    private ProductType type;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    private String color;

    private String description;

    @ElementCollection
    private Set<String> features;

    @ElementCollection
    private Set<String> materials;

    private String size;

    private String origin;

    private Date date;

    public Product(String name, double price, ProductType type) {
        this(type, name, price, null, null, null, null, null, null, new Date());
    }

    public void addMaterial(String material) {
        materials.add(material);
    }

    public void addFeature(String feature) {
        features.add(feature);
    }


}
