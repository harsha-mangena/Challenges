package com.harshamangina.watermanagement.Entity;

import com.harshamangina.watermanagement.Constants.Constants;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author : harsha mangina
 */

public class Apartment extends Community{

    @Getter private Integer consumptionPerMonth = 0;
    @Getter private Integer TenanatsInApartment = 0 ;
    @Getter private Integer totalGuets = 0;
    @Getter private Integer guestConsumption = 0;
    
    //Alloting and InitializingCommunity
    public void AllotWater(@NonNull Integer ApartmentType,  @NonNull Integer corporationShare, @NonNull Integer borewellShare){
        InitializeCommunity(corporationShare, borewellShare);
        if(ApartmentType == 2){
            TenanatsInApartment += Constants.TENANTS_IN_2BHK;
        }

        else if(ApartmentType == 3){
            TenanatsInApartment += Constants.TENANTS_IN_3BHK;
        }
        setConsumptionPerMonth(TenanatsInApartment);
    }

    //Method for setting the consumption per month like if 3 people -> 900, if 5 people -> 1500
    private void setConsumptionPerMonth(@NonNull Integer TenanatsInApartment) {
        consumptionPerMonth += TenanatsInApartment * Constants.MONTH_DAYS * Constants.ALLOTED_WATER_PER_DAY; 
    }

    //Method for adding guests
    public void addGuets(@NonNull Integer guests){
        guestConsumption += guests * Constants.MONTH_DAYS * Constants.ALLOTED_WATER_PER_DAY;
        totalGuets += guests;

    }

    //Method fot getting taoatl water consumed in a month.
    public Integer getTotalWaterComsumed(){
        return guestConsumption + consumptionPerMonth;
    }
    
}
