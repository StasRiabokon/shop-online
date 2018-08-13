package com.nau.shop.controllers;

import com.nau.shop.models.Product;
import com.nau.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/new-arrivals")
    public String newArrivals(Model model) {
        model.addAttribute("products", service.getAllOrderedByDate());
        return "new-arrivals";
    }

    @GetMapping("/bags")
    public String bags(Model model) {
        model.addAttribute("products", service.getBags());
        return "bags";
    }

    @GetMapping("/hats")
    public String hats(Model model) {
        model.addAttribute("products", service.getHats());
        return "hats";
    }


    @GetMapping("/polo")
    public String polo(Model model) {
        model.addAttribute("products", service.getPolo());
        return "polo";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping(value = {"/new-arrivals/{id}", "/bags/{id}", "/hats/{id}", "/polo/{id}"})
    public String product(@PathVariable Long id, Model model){
        model.addAttribute("products", service.getProduct(id));
        return "product";
    }

    @PostMapping("/admin/new")
    public String addNewProduct(Model model){
        model.addAttribute("products", new Product());
        return "addProduct";
    }

    @PostMapping("/admin/save")
    public String saveProduct(@ModelAttribute @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/home";
        }
        service.save(product);
        return "redirect:/new-arrivals";
    }

}
