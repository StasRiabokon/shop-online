package com.nau.shop.service;

import com.nau.shop.models.Product;
import com.nau.shop.models.ProductType;
import com.nau.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public List<Product> getAllOrderedByDate() {
        return repository.findAllByOrderByDateDesc();
    }

    @Override
    public List<Product> getBags() {
        return repository.getByType(ProductType.BAG);
    }

    @Override
    public List<Product> getHats() {
        return repository.getByType(ProductType.HAT);
    }

    @Override
    public List<Product> getPolo() {
        return repository.getByType(ProductType.POLO);
    }

    @Override
    public Product getProduct(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        return repository.save(product);
    }
}
