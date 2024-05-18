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

import java.util.List;


/*
    Nesta classe vamos criar um control dos nossos produtos
* */
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecorDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }


    @GetMapping("/products")
    //Este metodo tem como funcaao mostrar todos os produtos salvos na nossa base de dados
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }


}
