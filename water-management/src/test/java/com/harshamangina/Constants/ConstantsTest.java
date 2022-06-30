package com.harshamangina.Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.harshamangina.watermanagement.Constants.Constants;

public class ConstantsTest {
    
    @Test
    void testFor_BoreWellFlatRate(){
        assertEquals(Constants.FLAT_BOREWELL_PRICE, 1.5);
    }

    @Test
    void testFor_AllotedWaterPerDay(){
        assertEquals(Constants.ALLOTED_WATER_PER_DAY, 10);
    }

    @Test
    void testFor_DaysInAMonth(){
        assertEquals(Constants.MONTH_DAYS, 30);
    }

    @Test
    void testFor_CorporationFlatRate(){
        assertEquals(Constants.FLAT_CORPORATION_PRICE, 1.0);
    }

    @Test
    void testFor_TenantsIn2BHK(){
        assertEquals(Constants.TENANTS_IN_2BHK, 3);
    }

    @Test
    void testFor_TenantsIn3BHK(){
        assertEquals(Constants.TENANTS_IN_3BHK, 5);
    }

}
