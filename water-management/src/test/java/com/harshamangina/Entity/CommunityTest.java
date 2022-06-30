package com.harshamangina.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;

import com.harshamangina.watermanagement.Entity.Apartment;

@TestInstance(Lifecycle.PER_CLASS)
public class CommunityTest {
    
    @Mock 
    Apartment apartment;

    @BeforeAll
    void setUp(){
        apartment = new Apartment();
        apartment.InitializeCommunity(5, 8);
    }

    @Test
    void testFor_IntitializingCommunity(){
        assertEquals(5, apartment.getCorporationShare());
        assertEquals(8, apartment.getBorewellShare());

    }
}
