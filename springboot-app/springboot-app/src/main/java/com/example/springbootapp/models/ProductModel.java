package com.example.springbootapp.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCTS") //VIA DE CONEXAO COM A NOSSA TABELA DENTRO DA NOSSA BASE DE DADOS, a tabela foi criada aprtir daqui

public class ProductModel extends RepresentationModel<ProductModel> implements Serializable{
    /*
    NESTA CLASSE CRIAMOS O MODELO DE NOSSOS PRODUTOS
    * */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    /* @GeneratedValue(strategy= GenerationType.AUTO)
    nos permite dizer como vao ser gerados os nossos  identificadores que sao o name, id, value AUTO,fara uma atribuicao automatica de
    AUTO => vai fazer uma atribuicao automatica de valores para o nosso id(0,1,2,3...)*/

    private UUID idProduct; //UUID identificadores
    private String name;
    private BigDecimal price;

    public UUID getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getValue() {
        return price;
    }
    public void setValue(BigDecimal value) {
        this.price = value;
    }
}
