package com.harshamangina.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;

import com.harshamangina.watermanagement.Entity.Apartment;

@TestInstance(Lifecycle.PER_CLASS)
public class ApartmentTest {

    @Mock
    Apartment apartment;

    @BeforeAll
    void setUp(){
        apartment = new Apartment();
    }


    @Test
    void testFor_totalWaterConsumedInAMonth(){
        apartment.AllotWater(2, 3, 2);
        assertEquals(2700, apartment.getConsumptionPerMonth());
    }

    @Test
    void testFor_toatlWaterConsumedByGuests(){
        apartment.addGuets(10);
        assertEquals(4200, apartment.getGuestConsumption());
    }

    @Test
    void testFor_AddingGuest(){
        apartment.addGuets(3);
        assertEquals(4, apartment.getTotalGuets());
    }


    @Test
    void testFor_totalPeopleInApartment(){
        apartment.AllotWater(2, 1, 1);
        apartment.addGuets(1);
        assertEquals(4,  apartment.getTenanatsInApartment() + apartment.getTotalGuets());
    }

}
