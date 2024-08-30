package org.example.logic;

import org.example.model.Document;
import org.example.model.DrivingLicenseCard;
import org.example.request.DrivingLicenseRequest;

public class DrivingLicenseProducer implements DocumentFactory<DrivingLicenseRequest> {
    @Override
    public Document produceDocument(DrivingLicenseRequest request) {
        return new DrivingLicenseCard(request);
    }
}
