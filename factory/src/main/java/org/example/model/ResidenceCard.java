package org.example.model;

import org.example.request.ResidenceCardRequest;

import java.time.LocalDate;


public class ResidenceCard implements Document {
    //simplified structure (only the front part of the document)
    private final String firstName;
    private final String secondName;
    private final String nationality;
    private final LocalDate dateOfBirth;
    private final String sex;
    private final String documentNumber;
    private final String typeOfPermit;
    private final LocalDate expiryDate;

    public ResidenceCard(ResidenceCardRequest request) {
        this.firstName = request.firstName();
        this.secondName = request.secondName();
        this.nationality = request.nationality();
        this.dateOfBirth = request.dateOfBirth();
        this.sex = request.sex();
        this.documentNumber = request.documentNumber();
        this.typeOfPermit = request.typeOfPermit();
        this.expiryDate = request.expiryDate();
    }

    @Override
    public void getDocumentInfo() {
        System.out.println("Residence Card Info: full name - " + firstName + " " + secondName
                + ", nationality - " + nationality + ", date of birth - "
                + dateOfBirth + ", sex - " + sex + ", document number - " + documentNumber
                + ", type of permit - " + typeOfPermit + ", expiry Date - " + expiryDate);
    }
}
