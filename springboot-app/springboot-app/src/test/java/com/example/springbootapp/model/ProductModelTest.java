package com.example.springbootapp.model;

import com.example.springbootapp.models.ProductModel;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ProductModelTest {

    @Test
    public void testProductModel_gettersAndSetters() {
        // Arrange
        UUID expectedId = UUID.randomUUID();
        String expectedName = "Test Product";
        BigDecimal expectedValue = new BigDecimal(10.99);

        // Act
        ProductModel productModel = new ProductModel();
        productModel.setIdProduct(expectedId);
        productModel.setName(expectedName);
        productModel.setValue(expectedValue);

        // Assert
        assertEquals(expectedId, productModel.getIdProduct());
        assertEquals(expectedName, productModel.getName());
        assertEquals(expectedValue, productModel.getValue());
    }
}
