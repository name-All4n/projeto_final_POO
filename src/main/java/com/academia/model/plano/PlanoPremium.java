package com.academia.model.plano;

public class PlanoPremium extends Plano {
    private double taxaPiscina = 50.0;
    public PlanoPremium() {
        this.nome = "Plano Premium (Musculaçao + Piscina)";
        this.preco = 120.00;
    }
    @Override
    public double calcularMensalidade() {
        return this.preco + this.taxaPiscina;
    }
}
