package org.example;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class Customer {
    private final String firstName;
    private final String secondName;
    private final Address address;
    private final String email;
    private final String phone;

    private Customer(CustomerBuilder customerBuilder) {
        this.secondName = customerBuilder.secondName;
        this.firstName = customerBuilder.firstName;
        this.address = customerBuilder.address;
        this.email = customerBuilder.email;
        this.phone = customerBuilder.phone;
    }


    public static class CustomerBuilder {
        private final String firstName;
        private final  String secondName;
        private Address address;
        private String email;
        private final String phone;


        public CustomerBuilder(String firstName, String secondName, String phone) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.phone = phone;
        }

        public CustomerBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }


    }
}
