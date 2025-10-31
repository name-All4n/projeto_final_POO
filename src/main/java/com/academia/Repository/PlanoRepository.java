package com.academia.Repository;

import com.academia.model.plano.Plano;

import java.util.ArrayList;
import java.util.List;

public class PlanoRepository {
    private List<Plano> planos;

    public PlanoRepository() {
        this.planos = new ArrayList<>();
    }

    public void salvar(Plano plano) {
        this.planos.add(plano);
    }

    public Plano buscarPlano(String plano) {
        for (Plano p : this.planos) {
            if (p.getNome().equals(plano)) {
                return p;
            }
        }
        return null;
    }

    public List<Plano> listarPlanos() {
        return planos;
    }
}
