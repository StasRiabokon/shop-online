package com.nau.shop.repositories;

import com.nau.shop.models.Product;
import com.nau.shop.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> getByType(ProductType type);

    List<Product> findAllByOrderByDateDesc();


}
