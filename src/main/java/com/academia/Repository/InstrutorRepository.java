package com.academia.Repository;

import com.academia.model.pessoa.Instrutor;
import com.academia.model.pessoa.Membro;

import java.util.ArrayList;
import java.util.List;

public class InstrutorRepository {
    private List<Instrutor> instrutores;

    public InstrutorRepository() {
        this.instrutores = new ArrayList<>();
    }

    public void salvarInstrutor(Instrutor instrutor) {
        this.instrutores.add(instrutor);
    }

    public void removerInstrutor(String cpf) {
        for (Instrutor instrutor : this.instrutores) {
            if (instrutor.getCpf().equals(cpf)) {
                this.instrutores.remove(instrutor);
            }
        }
    }

    public List<Instrutor> listarInstrutores() {
        return instrutores;
    }

    public Instrutor procurarInstrutor(String cpf) {
        for (Instrutor instrutor : this.instrutores) {
            if (instrutor.getCpf().equals(cpf)) {
                return instrutor;
            }
        }
        return null;
    }
}
