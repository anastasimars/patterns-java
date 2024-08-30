package org.example.request;

import java.time.LocalDate;

public record DrivingLicenseRequest(String firstName, String secondName,
                                    LocalDate dateOfBirth, String placeOfBirth,
                                    LocalDate dateOfIssue, LocalDate dateOfExpiry,
                                    String issuingAuthority, String documentNumber,
                                    String categories) {
}
