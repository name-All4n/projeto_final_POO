package com.academia;

//classe de para testes

import com.academia.model.treino.ExercicioMusculacao;
import com.academia.model.treino.FichaDeTreino;

public class Main {
    public static void main(String[] args) {
        ExercicioMusculacao exercicio = new ExercicioMusculacao("supino", 4, 12);
        System.out.println(exercicio.getNomeExercicio());
        System.out.println(exercicio.getIntrucao());

        FichaDeTreino fichaDeTreino = new FichaDeTreino("Allan");
        fichaDeTreino.adicionarExercicio(new ExercicioMusculacao("supino inclinado", 4, 12));
        fichaDeTreino.adicionarExercicio(new ExercicioMusculacao("supino reto", 4, 12));
        System.out.println(fichaDeTreino.getExercicio());
    }
}
