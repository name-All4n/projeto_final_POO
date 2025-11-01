package com.academia.model.pessoa;

import com.academia.model.plano.Plano;
import com.academia.model.treino.FichaDeTreino;
import com.academia.services.templatemethod.MontadorDeFichaTreino;

import java.util.ArrayList;
import java.util.List;

public class Instrutor extends Pessoa {
    private String cref;
    private String especialidade;
    private List<Membro> alunos;

    public Instrutor() {
        super();
    }

    public Instrutor(String nome, String cpf, String cref, String especialidade) {
        super(nome, cpf);
        this.cref = cref;
        this.especialidade = especialidade;
        this.alunos = new ArrayList<>();
    }

    public void montarFicha(Membro membro, MontadorDeFichaTreino montarFicha) {
        FichaDeTreino novaFicha = montarFicha.montar(membro);
        membro.setFichaDeTreino(novaFicha);
        if(!this.alunos.contains(membro)) {
            this.alunos.add(membro);
        }
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Membro> getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return "Instrutor{" +
                "nome= " + getNome() + '\'' +
                "cref='" + cref + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", alunos=" + alunos +
                '}';
    }
}


