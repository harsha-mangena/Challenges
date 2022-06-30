package com.harshamangina.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.harshamangina.watermanagement.Entity.Apartment;
import com.harshamangina.watermanagement.Service.Operations.BillOperation;

@TestInstance(Lifecycle.PER_CLASS)
public class BillOperationTest {

    Apartment apartment;
    BillOperation service;

    @BeforeEach
    void setUp(){
        apartment = new Apartment();
    }

    @Test
    void testFor_BillOperationWithOutGuests(){
        String result = "900 1200";
        apartment.AllotWater(2, 1, 2);
        service = new BillOperation(apartment);
        assertEquals(result, service.generateBill());
    }

    @Test
    void testFor_BillOPeartionWithGuests(){
        String result = "2400 5215";
        apartment.AllotWater(2, 3, 7);
        apartment.addGuets(5);
        service = new BillOperation(apartment);
        assertEquals(result, service.generateBill());
    }

}

