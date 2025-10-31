package com.academia.model.plano;

public abstract class Plano {
    protected String nome;
    protected double preco;

    public Plano() {}

    public abstract double calcularMensalidade();

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
}

