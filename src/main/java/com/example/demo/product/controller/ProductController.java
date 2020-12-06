package com.example.demo.product.controller;


import com.example.demo.product.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    private Product getSampleProduct(long id){
        var product = new Product();
        product.setId(id);
        product.setName("Muiliukas kremukas" + id);
        product.setDescription("Labai grazys kremukas" + id);
        product.setInStock(22);
        product.setPrice(new BigDecimal(20+id));
        return product;
    }

    private List <Product> getProductList(int count){
        for(int i = 0; i < count; i++){
            products.add(getSampleProduct(i));
        }
        return products;
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable long id, Model model) {

        model.addAttribute("product", getSampleProduct(id));
        return "product/single-product";
    }
    @GetMapping
    public String getAllProducts(Model model){
        List<Product>  products = getProductList(5);
        model.addAttribute("products", products);
        return "product/product-list";
    }
}

