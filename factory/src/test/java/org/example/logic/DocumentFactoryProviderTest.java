package org.example.logic;

import org.example.model.Document;
import org.example.model.DrivingLicenseCard;
import org.example.model.IdCard;
import org.example.model.ResidenceCard;
import org.example.request.DrivingLicenseRequest;
import org.example.request.IdCardRequest;
import org.example.request.ResidenceCardRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DocumentFactoryProviderTest {
    private DocumentFactoryProvider provider;

    public static Stream<Arguments> shouldReturnDocumentsByRequest() {
        return Stream.of(Arguments.of(preparedResidenceCardTestRequest()),
                Arguments.of(preparedIdCardTestRequest()),
                Arguments.of(preparedDrivingLicenseTestRequest()));
    }

    @BeforeEach
    public void setUp() {
        provider = new DocumentFactoryProvider();
        provider.registerFactory(ResidenceCardRequest.class, new ResidenceCardProducer());
        provider.registerFactory(IdCardRequest.class, new IdCardProducer());
        provider.registerFactory(DrivingLicenseRequest.class, new DrivingLicenseProducer());
    }

    @ParameterizedTest
    @MethodSource("shouldReturnDocumentsByRequest")
    public void happyPath_createNewDocument_shouldReturnNewDocumentByRequest(Object request) {
        //when
        Document newDocument = provider.createNewDocument(request);

        //then
        assertNotNull(newDocument);
        if (request instanceof IdCardRequest) {
            assertInstanceOf(IdCard.class, newDocument);
        } else if (request instanceof ResidenceCardRequest) {
            assertInstanceOf(ResidenceCard.class, newDocument);
        } else if (request instanceof DrivingLicenseRequest) {
            assertInstanceOf(DrivingLicenseCard.class, newDocument);
        }
    }

    @Test
    public void uphappyPath_createNewDocument_shouldThrowExceptionForUnknownRequest(){
        Object unknownRequest = preparedUnknownRequest();

        // when & then
        assertThrows(RuntimeException.class, () -> provider.createNewDocument(unknownRequest));
    }


    static ResidenceCardRequest preparedResidenceCardTestRequest() {
        return new ResidenceCardRequest("Ivan",
                "Kowal",
                "Ukraina",
                LocalDate.of(1994, 7, 1),
                "M",
                "FA561893",
                "Czasowy pobyt",
                LocalDate.of(2025, 5, 9));
    }

    static IdCardRequest preparedIdCardTestRequest() {
        return new IdCardRequest("Ivan",
                "Kowal",
                "Ukraina",
                LocalDate.of(1994, 7, 1),
                "Dnipro", "M",
                "AA124432", "97070123111",
                LocalDate.of(2033, 5, 9));
    }

    static DrivingLicenseRequest preparedDrivingLicenseTestRequest() {
        return new DrivingLicenseRequest("Ivan",
                "Kowal",
                LocalDate.of(1994, 7, 1),
                "Dnipro, Ukraina",
                LocalDate.of(2024, 8, 30),
                LocalDate.of(2034, 8, 30),
                "Wrocław",
                "PO123421",
                "A/B");
    }

    static Object preparedUnknownRequest() {
        return new Object();
    }

}