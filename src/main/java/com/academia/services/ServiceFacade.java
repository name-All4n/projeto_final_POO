package com.academia.services;

import com.academia.Repository.InstrutorRepository;
import com.academia.Repository.MembroRepository;
import com.academia.Repository.PlanoRepository;
import com.academia.services.singleton.CatracaVirtual;


public class ServiceFacade {
    public static final MembroRepository membroRepo = new MembroRepository();
    public static final InstrutorRepository instrutorRepo = new InstrutorRepository();
    public static final PlanoRepository planoRepo = new PlanoRepository();
    public static final CatracaVirtual catraca = CatracaVirtual.getInstancia();

    private ServiceFacade() {}
}