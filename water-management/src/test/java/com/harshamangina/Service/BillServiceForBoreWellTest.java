package com.harshamangina.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;

import com.harshamangina.watermanagement.Service.BillService.BillServiceForBoreWell;


@TestInstance(Lifecycle.PER_CLASS)
public class BillServiceForBoreWellTest {

    @Mock
    BillServiceForBoreWell service;

    @BeforeAll
    void setUp(){
        service = new BillServiceForBoreWell(3, 900, 900, 1, 2);
    }

    @Test
    void testfor_ValidBoreWellBill(){
        assertEquals(450.00, service.getBill());
    }

}
