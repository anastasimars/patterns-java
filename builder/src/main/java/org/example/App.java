package org.example;


public class App 
{
    public static void main( String[] args )
    {
       Customer customer = new Customer
               .CustomerBuilder("John", "Doe", "+48654111987")
               .setEmail("johndoe@gmail.com")
               .setAddress(new Address.AddressBuilder("London",
                       "Whiter 12",
                       "43268")
                       .setCountry("UK")
                       .build())
               .build();

        System.out.printf(String.valueOf(customer));
    }
}
