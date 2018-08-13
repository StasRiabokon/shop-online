package com.nau.shop.service;

import com.nau.shop.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getAllOrderedByDate();

    List<Product> getBags();

    List<Product> getHats();

    List<Product> getPolo();

    Product getProduct(Long id);

    Product save(Product product);

    void delete(Long id);

    Product update(Product product);
}
