package com.academia;

//classe de para testes

import com.academia.model.treino.ExercicioMusculacao;

public class Main {
    public static void main(String[] args) {
        ExercicioMusculacao exercicio = new ExercicioMusculacao("supino", 4, 12);
        System.out.println(exercicio.getNomeExercicio());
        System.out.println(exercicio.getIntrucao());
    }
}
