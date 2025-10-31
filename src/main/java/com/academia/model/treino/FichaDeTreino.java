package com.academia.model.treino;

import java.util.ArrayList;
import java.util.List;

public class FichaDeTreino {
    private String nomeAluno;
    private List<Exercicio> exercicio;

    public FichaDeTreino() {}

    public FichaDeTreino(String nomeAluno) {
        this.nomeAluno = nomeAluno;
        this.exercicio = new ArrayList<Exercicio>();
    }

    //adicona exercícios individualmente na lista
    public void adicionarExercicio(Exercicio exercicio) {
        this.exercicio.add(exercicio);
    }

    //adicona uma lista de exercícios na lista
    public void adiconarExercicios(List<Exercicio> exercicios) {
        this.exercicio.addAll(exercicios);
    }

    //mostrar os exercícios da lista
    public List<Exercicio> getExercicio() {
        return exercicio;
    }

    //mostra o nome do aluno
    public String getNomeAluno() {
        return nomeAluno;
    }
}
