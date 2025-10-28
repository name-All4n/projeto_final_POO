package com.academia.model.treino;

public class ExercicioMusculacao implements Exercicio {
    private String nome;
    private int series;
    private int repeticoes;

    public ExercicioMusculacao() {}

    public ExercicioMusculacao(String nome, int series, int repeticoes) {
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    @Override
    public String getNomeExercicio() {
        return nome;
    }

    @Override
    public String getIntrucao() {
        return String.format("%d Séries de 5d Repetições", series, repeticoes);
    }
}
