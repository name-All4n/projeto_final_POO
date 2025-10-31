package com.academia;

//classe de para testes

import com.academia.Repository.MembroRepository;
import com.academia.Repository.PlanoRepository;
import com.academia.model.Matricula;
import com.academia.model.pessoa.Membro;
import com.academia.model.plano.Plano;
import com.academia.model.plano.PlanoMusculacao;
import com.academia.model.plano.PlanoPremium;
import com.academia.model.treino.ExercicioMusculacao;
import com.academia.model.treino.FichaDeTreino;
import com.academia.services.templatemethod.MontadorDeFichaTreino;
import com.academia.services.templatemethod.MontadorFichaEmagrecimento;
import com.academia.services.templatemethod.MontadorFichaHipertrofia;

public class Main {
    public static void main(String[] args) {
        ExercicioMusculacao exercicio = new ExercicioMusculacao("supino", 4, 12);
        System.out.println(exercicio.getNomeExercicio());
        System.out.println(exercicio.getIntrucao());

        FichaDeTreino fichaDeTreino = new FichaDeTreino("Allan");
        fichaDeTreino.adicionarExercicio(new ExercicioMusculacao("supino inclinado", 4, 12));
        fichaDeTreino.adicionarExercicio(new ExercicioMusculacao("supino reto", 4, 12));
        System.out.println(fichaDeTreino.getExercicio());

        Membro allan = new Membro("Allan", "123.456.789-10");
        MembroRepository membroRepository = new MembroRepository();
        Membro joao = new Membro("Joao", "123.456.789-20");
        membroRepository.salvar(allan);
        membroRepository.salvar(joao);
        allan.setMatricula(new Matricula(new PlanoMusculacao()));
        System.out.println(membroRepository.listarMembros());
        System.out.println(membroRepository.procurarMembro("123.456.789-10"));
        membroRepository.atualizar("123.456.789-10", "Allan Pedro", new PlanoPremium());
        joao.setMatricula(new Matricula(new PlanoMusculacao()));
        System.out.println(membroRepository.listarMembros());

        PlanoRepository planos = new PlanoRepository();
        planos.salvar(new PlanoMusculacao());
        planos.salvar(new PlanoPremium());
        System.out.println(planos.buscarPlano("Plano Musculação"));
        System.out.println(planos.listarPlanos());

        MontadorDeFichaTreino montarFicha1 = new MontadorFichaHipertrofia();
        MontadorDeFichaTreino montarFicha2 = new MontadorFichaEmagrecimento();
        FichaDeTreino fichaDeTreino1 = montarFicha1.montar(allan);
        FichaDeTreino fichaDeTreino2 = montarFicha2.montar(joao);
        allan.setFichaDeTreino(fichaDeTreino1);
        joao.setFichaDeTreino(fichaDeTreino2);
        System.out.println(allan.getFichaDeTreino());
        System.out.println(joao.getFichaDeTreino());
    }
}
