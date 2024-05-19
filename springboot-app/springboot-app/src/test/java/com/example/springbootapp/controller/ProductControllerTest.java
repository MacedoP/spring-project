package com.example.springbootapp.controller;


import com.example.springbootapp.datatranferobject.ProductRecorDto;
import com.example.springbootapp.models.ProductModel;
import com.example.springbootapp.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductRepository productRepository;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

//    @Test
//    public void testSaveProduct() {
//        ProductRecorDto productDto = new ProductRecorDto();
//        ProductModel productModel = new ProductModel();
//        BeanUtils.copyProperties(productDto, productModel);
//
//        when(productRepository.save(any(ProductModel.class))).thenReturn(productModel);
//
//        ResponseEntity<ProductModel> response = productController.saveProduct(productDto);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(productModel, response.getBody());
//    }
//
//    @Test
//    public void testGetAllProducts() {
//        ProductModel productModel = new ProductModel();
//        UUID id = UUID.randomUUID();
//        productModel.setIdProduct(id);
//        when(productRepository.findAll()).thenReturn(Collections.singletonList(productModel));
//
//        ResponseEntity<List<ProductModel>> response = productController.getAllProducts();
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(1, response.getBody().size());
//        assertEquals(id, response.getBody().get(0).getIdProduct());
//    }
//
//    @Test
//    public void testGetOneProduct() {
//        UUID id = UUID.randomUUID();
//        ProductModel productModel = new ProductModel();
//        productModel.setIdProduct(id);
//        when(productRepository.findById(id)).thenReturn(Optional.of(productModel));
//
//        ResponseEntity<Object> response = productController.getOneProduct(id);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(productModel, response.getBody());
//    }
//
//    @Test
//    public void testGetOneProductNotFound() {
//        UUID id = UUID.randomUUID();
//        when(productRepository.findById(id)).thenReturn(Optional.empty());
//
//        ResponseEntity<Object> response = productController.getOneProduct(id);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertEquals("Product not found.", response.getBody());
//    }
//
//    @Test
//    public void testUpdateProduct() {
//        UUID id = UUID.randomUUID();
//        ProductRecorDto productDto = new ProductRecorDto();
//        ProductModel productModel = new ProductModel();
//        productModel.setIdProduct(id);
//        when(productRepository.findById(id)).thenReturn(Optional.of(productModel));
//        when(productRepository.save(any(ProductModel.class))).thenReturn(productModel);
//
//        ResponseEntity<Object> response = productController.updateProduct(id, productDto);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(productModel, response.getBody());
//    }
//
//    @Test
//    public void testUpdateProductNotFound() {
//        UUID id = UUID.randomUUID();
//        ProductRecorDto productDto = new ProductRecorDto();
//        when(productRepository.findById(id)).thenReturn(Optional.empty());
//
//        ResponseEntity<Object> response = productController.updateProduct(id, productDto);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertEquals("Product not found.", response.getBody());
//    }
//
//
//
//    @Test
//    public void testDeleteProduct() {
//        UUID id = UUID.randomUUID();
//        ProductModel productModel = new ProductModel();
//        productModel.setIdProduct(id);
//        when(productRepository.findById(id)).thenReturn(Optional.of(productModel));
//
//        ResponseEntity<Object> response = productController.deleteProduct(id);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Product deleted successfully.", response.getBody());
//        verify(productRepository, times(1)).delete(productModel);
//    }
//
//    @Test
//    public void testDeleteProductNotFound() {
//        UUID id = UUID.randomUUID();
//        when(productRepository.findById(id)).thenReturn(Optional.empty());
//
//        ResponseEntity<Object> response = productController.deleteProduct(id);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertEquals("Product not found.", response.getBody());
//    }

}
