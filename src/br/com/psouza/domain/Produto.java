package br.com.psouza.domain;

import java.util.Objects;
import java.util.UUID;

public class Produto {
    private String id;
    private String nome;
    private Integer preco;
    private String codigo;

    public Produto(String nome, Integer preco, String codigo) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}