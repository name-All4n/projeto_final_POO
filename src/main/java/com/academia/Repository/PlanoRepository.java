package com.academia.Repository;

import com.academia.model.plano.Plano;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PlanoRepository {
    private List<Plano> planos;
    private static final String FILE_PATH = "planos.json";
    private Gson gson;

    public PlanoRepository() {
        this.gson = new GsonBuilder().registerTypeAdapter(Plano.class, new PlanoTypeAdapter()).setPrettyPrinting().create();
        this.planos = carregarDoArquivo();
    }

    private List<Plano> carregarDoArquivo() {
        try (Reader reader = new FileReader(FILE_PATH)){
            Type listType = new TypeToken<List<Plano>>(){}.getType();
            List<Plano> lista = gson.fromJson(reader, listType);

            if (lista == null) {
                return new ArrayList<>();
            }
            System.out.println("Planos carregados do arquivo" + FILE_PATH);
            return lista;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void salvarNoArquivo() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(planos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvar(Plano plano) {
        this.planos.add(plano);
        salvarNoArquivo();
        System.out.println("Plano" + plano.getNome() +"salvo com sucesso!");
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

    private static class PlanoTypeAdapter implements JsonDeserializer<Plano>, JsonSerializer<Plano> {
        private static final String CLASSNAME_PROPERTY = "CLASSE_TYPE";

        @Override
        public JsonElement serialize(Plano src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject jsonObject = context.serialize(src).getAsJsonObject();
            jsonObject.addProperty(CLASSNAME_PROPERTY, src.getClass().getSimpleName());
            return jsonObject;
        }

        @Override
        public Plano deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonElement classNameElement = jsonObject.get(CLASSNAME_PROPERTY);
            if (classNameElement == null) {
                throw new JsonParseException("Não foi possível desserializar Plano: propriedade " + CLASSNAME_PROPERTY + " ausente.");
            }

            String className = classNameElement.getAsString();

            try {
                Class<?> clazz = Class.forName(className);
                return (Plano) jsonDeserializationContext.deserialize(jsonElement, clazz);
            } catch (ClassNotFoundException e) {
                throw new JsonParseException("Classe não encontrada: " + className, e);
            }
        }
    }
}
