package com.academia.services.templatemethod;

import com.academia.model.treino.Exercicio;

import java.util.ArrayList;
import java.util.List;

public class MontadorFichaEmagrecimento extends MontadorDeFichaTreino {

    @Override
    protected List<Exercicio> adiconarExerciciosPrincipais() {
        List<Exercicio> exercicios = new ArrayList<Exercicio>();
    }
}
