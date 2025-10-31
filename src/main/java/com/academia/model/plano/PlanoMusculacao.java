package com.academia.model.plano;

public class PlanoMusculacao extends Plano{
    public PlanoMusculacao() {
        this.nome = "Plano Musculação";
        this.preco = 100.00;
    }
    @Override
    public double calcularMensalidade() {
        return this.preco;
    }

    @Override
    public String toString() {
        return "PlanoMusculacao{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
