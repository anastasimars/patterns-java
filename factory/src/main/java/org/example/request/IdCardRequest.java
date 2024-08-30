package org.example.request;

import java.time.LocalDate;

public record IdCardRequest(String firstName, String secondName,
                            String nationality, LocalDate dateOfBirth,
                            String placeOfBirth, String sex, String documentNumber,
                            String personalNumber, LocalDate expiryDate) {
}
