package com.harshamangina.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;

import com.harshamangina.watermanagement.Service.BillService.BillServiceForCorporation;

@TestInstance(Lifecycle.PER_CLASS)
public class BillServiceForCorporationTest {
    
    @Mock
    BillServiceForCorporation service;

    @BeforeAll
    void setUp(){
        service = new BillServiceForCorporation(3, 900, 900, 1, 2);
    }

    @Test
    void testfor_ValidCorporation(){
        assertEquals(600.00, 600);
    }
}
