package com.academia.model.plano;

public abstract class Plano {
    private int id;
    protected String nome;
    protected double preco;

    public Plano() {}

    public abstract double calcularMensalidade();

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getPreco() {
        return preco;
    }
}

