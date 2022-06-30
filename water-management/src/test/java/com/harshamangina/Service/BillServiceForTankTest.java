package com.harshamangina.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;

import com.harshamangina.watermanagement.Service.BillService.BillServiceForTank;

@TestInstance(Lifecycle.PER_CLASS)
public class BillServiceForTankTest {
    
    @Mock
    BillServiceForTank service;

    @BeforeAll
    void setUp(){
        service = new BillServiceForTank(10, 3000, 900, 1, 2);
    }

    @Test
    void testFor_ValidTank(){
        assertEquals(6000, 6000);
    }

}
