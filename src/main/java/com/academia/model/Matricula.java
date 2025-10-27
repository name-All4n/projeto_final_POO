package com.academia.model;

import com.academia.model.plano.Plano;

import java.util.Calendar;
import java.util.Date;

public class Matricula {
    private Plano plano;
    private Date dataMatricula;
    private Date dataVencimento;

    public Matricula() {}

    public Matricula(Plano plano) {
        this.plano = plano;
        this.dataMatricula = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(this.dataMatricula);
        c.add(Calendar.DAY_OF_MONTH, 30);
        this.dataVencimento = c.getTime();
    }

    public Plano getPlano() {
        return plano;
    }
    public Date getDataVencimento() {
        return dataVencimento;
    }
    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public boolean isAtiva() {
        return new Date().before(this.dataVencimento);
    }
}
