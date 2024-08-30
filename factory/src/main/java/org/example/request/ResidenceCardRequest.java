package org.example.request;

import java.time.LocalDate;

public record ResidenceCardRequest(String firstName, String secondName, String nationality,
                                   LocalDate dateOfBirth, String sex, String documentNumber,
                                   String typeOfPermit, LocalDate expiryDate) {

}
