package com.academia.services.templatemethod;

import com.academia.model.pessoa.Membro;
import com.academia.model.treino.Exercicio;
import com.academia.model.treino.FichaDeTreino;

import java.util.List;

public abstract class MontadorDeFichaTreino {
    public final FichaDeTreino montar(Membro membro){
        FichaDeTreino ficha = new FichaDeTreino(membro.getNome());
        ficha.adiconarExercicios(adiconarExerciciosPrincipais());
        return ficha;
    }
    protected abstract List<Exercicio> adiconarExerciciosPrincipais();
}
