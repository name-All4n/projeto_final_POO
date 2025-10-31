package com.academia.model.treino;

public class ExercicioAerobico implements Exercicio {
    private String nome;
    private int minutos;

    public ExercicioAerobico() {}

    public ExercicioAerobico(String nome, int minutos) {
        this.nome = nome;
        this.minutos = minutos;
    }

    @Override
    public String getNomeExercicio() {
        return nome;
    }

    @Override
    public String getIntrucao() {
        return String.format("%d minutos", minutos);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", minutos=" + minutos +
                '}';
    }
}
