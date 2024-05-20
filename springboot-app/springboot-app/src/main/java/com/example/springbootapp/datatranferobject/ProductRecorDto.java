package com.example.springbootapp.datatranferobject;

import jakarta.validation.constraints.NotBlank;

public record ProductRecorDto(@NotBlank String name, double value) {
    /*
        @NotNUll => siginifica que o nome nao pode estar vazio ou em branco
        @NotNull => significa que o preco nao pode estar vazio

    * */


}
