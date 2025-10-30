package com.academia.Repository;

import com.academia.model.pessoa.Membro;

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

    public Membro procurarMembro(String Nome) {
        for (Membro membro : membros) {
            if (membro.getNome().equals(Nome)) {
                return membro;
            }
        }
        return null;
    }

    public List<Membro> listarMembros() {
        return membros;
    }
}
