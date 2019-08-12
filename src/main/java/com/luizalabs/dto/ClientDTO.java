package com.luizalabs.dto;

import java.io.Serializable;
import java.util.Set;

public class ClientDTO implements Serializable {

    private String nome;
    private String endereco;
    private String email;

    private Set<ProductDTO> favoriteProducts;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ProductDTO> getFavoriteProducts() {
        return favoriteProducts;
    }

    public void setFavoriteProducts(Set<ProductDTO> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
    }
}
