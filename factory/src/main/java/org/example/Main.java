package org.example;

import org.example.logic.DocumentFactoryProvider;
import org.example.logic.ResidenceCardProducer;
import org.example.model.Document;
import org.example.request.ResidenceCardRequest;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DocumentFactoryProvider documentFactoryProvider = new DocumentFactoryProvider();
        documentFactoryProvider.registerFactory(ResidenceCardRequest.class,
                new ResidenceCardProducer());

        ResidenceCardRequest residenceCardRequest = new ResidenceCardRequest("Ivan",
                "Kowal",
                "Ukraina",
                LocalDate.of(1994, 7, 1),
                "M",
                "FA561893",
                "Czasowy pobyt",
                LocalDate.of(2025, 5,9));


        Document newDocument = documentFactoryProvider.createNewDocument(residenceCardRequest);
        newDocument.getDocumentInfo();

    }
}
