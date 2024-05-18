package com.example.springbootapp.datatranferobject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecorDto(@NotBlank String name, @NotNull BigDecimal value) {
    /*
        @NotNUll => siginifica que o nome nao pode estar vazio ou em branco
        @NotNull => significa que o preco nao pode estar vazio

    * */


}
