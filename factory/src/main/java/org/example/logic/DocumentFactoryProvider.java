package org.example.logic;

import org.example.model.Document;

import java.util.HashMap;
import java.util.Map;

public class DocumentFactoryProvider {
    private final Map<Class<?>, DocumentFactory<?>> factories = new HashMap<>();

    public void registerFactory(Class<?> requestType, DocumentFactory<?> factory) {
        factories.put(requestType, factory);
    }


    public <T> Document createNewDocument(T request) {
        DocumentFactory<T> documentFactory = (DocumentFactory<T>) factories
                .get(request.getClass());
       if(documentFactory != null){
           return documentFactory.produceDocument(request);
       } else{
           throw new RuntimeException("Unknown type of request");
       }
    }

}
