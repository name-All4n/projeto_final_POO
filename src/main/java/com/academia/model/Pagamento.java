package com.academia.model;


public class Pagamento {
    private String aluno;
    private String valor;

    public Pagamento(String aluno, String valor) {
        this.aluno = aluno;
        this.valor = valor;
    }

    public String getAluno() {
        return aluno;
    }

    public String getValor() {
        return valor;
    }
}
