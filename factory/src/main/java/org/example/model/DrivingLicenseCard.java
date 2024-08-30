package org.example.model;

import org.example.request.DrivingLicenseRequest;

import java.time.LocalDate;


public class DrivingLicenseCard implements Document {
    //simplified structure (only the front part of the document)
    private final String firstName;
    private final String secondName;
    private final LocalDate dateOfBirth;
    private final String placeOfBirth;
    private final LocalDate dateOfIssue; // (4a)
    private final LocalDate dateOfExpiry; // (4b)
    private final String issuingAuthority; // 4c)
    private final String documentNumber; // (5)
    private final String categories;

    public DrivingLicenseCard(DrivingLicenseRequest request) {
        this.firstName = request.firstName();
        this.secondName = request.secondName();
        this.dateOfBirth = request.dateOfBirth();
        this.placeOfBirth = request.placeOfBirth();
        this.dateOfIssue = request.dateOfIssue();
        this.dateOfExpiry = request.dateOfExpiry();
        this.issuingAuthority = request.issuingAuthority();
        this.documentNumber = request.documentNumber();
        this.categories =request.categories();
    }

    @Override
    public void getDocumentInfo() {
        System.out.println("Driver's License Card Info: full name - " + firstName + " " + secondName
                + ", date of birth - " + dateOfBirth + ", place of birth - " + placeOfBirth
                + ", date of issue - " + dateOfIssue + ", date of expiry - " + dateOfExpiry
                + ", document number - " + documentNumber + ", issuing authority - " + issuingAuthority
                + ", categories -" + categories);
    }
}
