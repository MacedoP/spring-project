package com.example.springbootapp.controller;
import com.example.springbootapp.datatranferobject.ProductRecorDto;
import com.example.springbootapp.models.ProductModel;
import com.example.springbootapp.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/*
    Nesta classe vamos criar um control dos nossos produtos
* */
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")//isto esta sendo usado para pegar os valores passados dentro do postman
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecorDto productRecorDto){
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecorDto, productModel);//O que vai ser convertido e o tipo no qual sera convertido
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

}
