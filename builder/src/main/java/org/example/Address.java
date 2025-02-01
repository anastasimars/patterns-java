package org.example;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class Address {
    private final String city;
    private final String streetWithNumber;
    private final String postalCode;

    private Address(AddressBuilder addressBuilder) {
        this.city = addressBuilder.city;
        this.streetWithNumber = addressBuilder.streetWithNumber;
        this.postalCode = addressBuilder.postalCode;
    }

    public static class AddressBuilder{
        private final String city;
        private final String streetWithNumber;
        private final String postalCode;
        private String country;

        public AddressBuilder(String city, String streetWithNumber, String postalCode) {
            //mandatory fields
            this.city = city;
            this.streetWithNumber = streetWithNumber;
            this.postalCode = postalCode;
        }

        public AddressBuilder setCountry(String country){
            this.country = country;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }
}


