package org.example.logic;

import org.example.model.Document;
import org.example.model.ResidenceCard;
import org.example.request.ResidenceCardRequest;

public class ResidenceCardProducer implements DocumentFactory<ResidenceCardRequest> {

    @Override
    public Document produceDocument(ResidenceCardRequest request) {
        return new ResidenceCard(request);
    }
}
