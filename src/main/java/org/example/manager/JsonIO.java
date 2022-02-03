package org.example.manager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonIO{
    private ObjectMapper objectMapper;

    public JsonIO() {

        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
       objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());
    }


    public <T> void serializeToJson(List<T> objectsList, File source){
        try{
            objectMapper.writeValue(source, objectsList);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public <T> List<T> deserializeFromJson(File source){
        List<T> objects = new ArrayList<>();
        try{
            objects = objectMapper.readValue(source, new TypeReference<List<T>>(){});
        }catch (IOException exception){
            exception.printStackTrace();
        }
        return objects;
    }
}
