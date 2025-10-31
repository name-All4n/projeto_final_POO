package com.academia.Repository;

import com.academia.model.Matricula;
import com.academia.model.pessoa.Membro;
import com.academia.model.plano.Plano;

import java.util.ArrayList;
import java.util.List;

public class MembroRepository {
    private List<Membro> membros;

    public MembroRepository() {
        this.membros = new ArrayList<>();
    }

    public void salvar(Membro membro) {
        this.membros.add(membro);
    }

    public Membro procurarMembro(String cpf) {
        for (Membro membro : this.membros) {
            if (membro.getCpf().equals(cpf)) {
                return membro;
            }
        }
        return null;
    }

    public List<Membro> listarMembros() {
        return membros;
    }

    public void atualizar(String cpf, String novoNome, Plano novoPlano) {
        for (Membro m : membros) {
            if (m.getCpf().equals(cpf)) {
                if (novoNome != null && !novoNome.isEmpty()) {
                    m.setNome(novoNome);
                }
                if (novoPlano != null) {
                    m.setMatricula(new Matricula(novoPlano));
                }
                return; // Sai do método após atualizar
            }
        }
        System.out.println("Membro com CPF " + cpf + " não encontrado.");
    }

}
