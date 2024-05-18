package com.example.springbootapp.controller;
import com.example.springbootapp.datatranferobject.ProductRecorDto;
import com.example.springbootapp.models.ProductModel;
import com.example.springbootapp.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


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

    @GetMapping("/products")//GET ALL
    //Este metodo tem como funcaao mostrar todos os produtos salvos na nossa base de dados

    public ResponseEntity<List<ProductModel>> getAllProducts(){
        List<ProductModel> productModelList = productRepository.findAll();
        if(!productModelList.isEmpty()){
            for (ProductModel product : productModelList){
                UUID id = product.getIdProduct();
                product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(productModelList);
    }

    @GetMapping("/products/{id}")//GET ONE
    //Este metodo nos permite pegar um unico produto na nossa base de dados

    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id){
                Optional<ProductModel> productO = productRepository.findById(id);
                    if(productO.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productO.get());
    }
    @PutMapping("/products/{id}") //UPDATE ONE or ALL
    //Este metodo nos permite actualizar os nosso produtos pelo id do produto

    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id, @RequestBody @Valid ProductRecorDto productRecordDto) {
                Optional<ProductModel> productO = productRepository.findById(id);
                    if(productO.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var productModel = productO.get();
            BeanUtils.copyProperties(productRecordDto, productModel);
                return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    @DeleteMapping("/products/{id}")//DELETE ONE or ALL
    //Este metodo vai ser usado para deletar produtos

    public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
                Optional<ProductModel> productO = productRepository.findById(id);
                    if(productO.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        productRepository.delete(productO.get());
            return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }

}
