package com.example.pruebamvc;

import com.example.pruebamvc.modelo.Persona;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Jackson {

    public static <T> void serializar(T objeto,String pathJson){
        File file = new File(pathJson);
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file,objeto);
        }
        catch (IOException e){
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    public static <T> ArrayList<T> deserializarArrayList(String pathJson, Class clase){

        File file = new File(pathJson);

        ObjectMapper mapper = new ObjectMapper();

        ArrayList<T> objetos = null;

        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, clase);
            objetos = mapper.readValue(file, collectionType);

        } catch (IOException e){
            System.out.println(e);
            throw new RuntimeException(e);
        }
        finally {
            return objetos;
        }
    }
}
