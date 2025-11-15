package com.academia.Repository;

import com.academia.model.pessoa.Instrutor;
import com.academia.model.pessoa.Membro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InstrutorRepository {
    private List<Instrutor> instrutores;
    private static final String FILE_PATH = "instrutores.txt";
    private Gson gson;

    public InstrutorRepository() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.instrutores = carregarDoArquivo();
    }

    private List<Instrutor> carregarDoArquivo() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Instrutor>>(){}.getType();
            List<Instrutor> lista = gson.fromJson(reader, listType);

            if (lista == null) {
                return new ArrayList<>();
            }
            System.out.println("Instrutores carregados do arquivo" + FILE_PATH);
            return lista;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void salvarNoArquivo() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(instrutores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvarInstrutor(Instrutor instrutor) {
        this.instrutores.add(instrutor);
        salvarNoArquivo();
        System.out.println("Instrutor" + instrutor.getNome() + "salvo com sucesso!");
    }

    public void removerInstrutor(String cpf) {
        for (Instrutor instrutor : this.instrutores) {
            if (instrutor.getCpf().equals(cpf)) {
                this.instrutores.remove(instrutor);
                salvarNoArquivo();
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
