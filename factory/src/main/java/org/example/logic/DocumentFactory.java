package org.example.logic;

import org.example.model.Document;

public interface DocumentFactory<T> {
    Document produceDocument(T request);

}
