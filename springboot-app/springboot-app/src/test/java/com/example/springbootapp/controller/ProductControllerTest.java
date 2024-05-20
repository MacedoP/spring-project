package com.example.springbootapp.controller;

import com.example.springbootapp.controller.ProductController;
import com.example.springbootapp.datatranferobject.ProductRecorDto;
import com.example.springbootapp.models.ProductModel;
import com.example.springbootapp.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductControllerTest {

    @Mock
    private ProductRepository productRepositoryMock;

    @Autowired
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productController.productRepository = productRepositoryMock;
    }

    @Test
    public void testSaveProduct_success() {
        // Arrange
        ProductRecorDto productRecordDto = new ProductRecorDto("Test Product", 524.00);
        ProductModel productModel = new ProductModel();

        when(productRepositoryMock.save(productModel)).thenReturn(productModel);

        // Act
        ResponseEntity<ProductModel> responseEntity = productController.saveProduct(productRecordDto);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        verify(productRepositoryMock, times(1)).save(productModel);
    }

    @Test
    public void testGetAllProducts_success() {
        // Arrange
        List<ProductModel> productList = new ArrayList<>();
        productList.add(new ProductModel());
        productList.add(new ProductModel());

        when(productRepositoryMock.findAll()).thenReturn(productList);

        // Act
        ResponseEntity<List<ProductModel>> responseEntity = productController.getAllProducts();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(productList, responseEntity.getBody());
        verify(productRepositoryMock, times(1)).findAll();
    }

    @Test
    public void testGetAllProducts_emptyList() {
        // Arrange
        List<ProductModel> emptyList = new ArrayList<>();

        when(productRepositoryMock.findAll()).thenReturn(emptyList);

        // Act
        ResponseEntity<List<ProductModel>> responseEntity = productController.getAllProducts();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertTrue(Objects.requireNonNull(responseEntity.getBody()).isEmpty());
        verify(productRepositoryMock, times(1)).findAll();
    }

    @Test
    public void testGetOneProduct_success() {
        // Arrange
        UUID id = UUID.randomUUID();
        ProductModel productModel = new ProductModel();

        when(productRepositoryMock.findById(id)).thenReturn(Optional.of(productModel));

        // Act
        ResponseEntity<Object> responseEntity = productController.getOneProduct(id);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(productModel, responseEntity.getBody());
        verify(productRepositoryMock, times(1)).findById(id);
    }

    @Test
    public void testGetOneProduct_notFound() {
        // Arrange
        UUID id = UUID.randomUUID();

        when(productRepositoryMock.findById(id)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Object> responseEntity = productController.getOneProduct(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Product not found.", responseEntity.getBody());
        verify(productRepositoryMock, times(1)).findById(id);
    }

    @Test
    public void testUpdateProduct_success() {
        // Arrange
        UUID id = UUID.randomUUID();
        ProductModel existingProduct = new ProductModel();
    }
}
