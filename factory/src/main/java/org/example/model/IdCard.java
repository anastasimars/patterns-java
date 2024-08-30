package org.example.model;

import org.example.request.IdCardRequest;

import java.time.LocalDate;


public class IdCard implements Document {
    //simplified structure (only the front part of the document)
    private final String firstName;
    private final String secondName;
    private final String nationality;
    private final LocalDate dateOfBirth;
    private final String placeOfBirth;
    private final String sex;
    private final String documentNumber;
    private final String personalNumber;
    private final LocalDate expiryDate;

    public IdCard(IdCardRequest request) {
        this.firstName = request.firstName();
        this.secondName = request.secondName();
        this.nationality = request.nationality();
        this.dateOfBirth = request.dateOfBirth();
        this.placeOfBirth = request.placeOfBirth();
        this.documentNumber =request.documentNumber();
        this.sex = request.sex();
        this.expiryDate = request.expiryDate();
        this.personalNumber = request.personalNumber();
    }

    @Override
    public void getDocumentInfo() {
        System.out.println("ID Card Info: full name - " + firstName + " " + secondName
                + ", nationality - " + nationality + ", date of birth - "
                + dateOfBirth + ", place of birth - " + placeOfBirth
                + ", sex - " + sex + ", document number - " + documentNumber
                + ", personal number - " + personalNumber + ", expiry Date - " + expiryDate);

    }
}
