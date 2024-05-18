package com.example.springbootapp.controller;
import com.example.springbootapp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/*
    Nesta classe vamos criar um control dos nossos produtos
* */
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;
}
