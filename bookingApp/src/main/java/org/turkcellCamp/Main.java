package org.turkcellCamp;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        CorporateCustomer corporateCustomer1 = new CorporateCustomer(1,"1234567890","Turkcell");


        IndividualCustomer individualCustomer1 = new IndividualCustomer();
        individualCustomer1.setId(2);
        individualCustomer1.setFirstName("Kadir");
        individualCustomer1.setLastName("Ulge");
        individualCustomer1.setNationalityId("012345678910");
	    IndividualCustomer individualCustomer2 = new IndividualCustomer(3, "Basak", "Ulge", "712345678913");

        Hotel hotel1 = new Hotel(1,"Hilton");

        Booking booking = new Booking();
        booking.setId(1);
        booking.setStartDate(new Date());
        booking.setEndDate(new Date());
        booking.setDailyPrice(3000);
        booking.setCustomer(individualCustomer1);
        booking.setHotel(hotel1);

        // to DB





    }
}