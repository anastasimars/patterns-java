package org.example.logic;

import org.example.model.Document;
import org.example.model.IdCard;
import org.example.request.IdCardRequest;

public class IdCardProducer implements DocumentFactory<IdCardRequest> {

    @Override
    public Document produceDocument(IdCardRequest request) {
        return new IdCard(request);
    }

}
