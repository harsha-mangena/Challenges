package com.challenges.watermanagement.Entity;

import com.challenges.watermanagement.Constants.Constants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@NoArgsConstructor
public class Apartment extends Community{

    private Integer guests = 0;
    @NonNull private Integer people = 0;
    @Getter @NonNull private Integer monthlyConsumption = 0;
    @Getter private int waterConsumedByGuests = 0;


    public void AllotWater(@NonNull Integer ApartmentType, @NonNull Integer boreWellShare, @NonNull Integer corporationShare){
        InitializeCommunity(boreWellShare, corporationShare);
        if(ApartmentType == 2){
            people += Constants.TENANTS_IN_2BHK;
        }

        if(ApartmentType == 3){
            people += Constants.TENANTS_IN_3BHK;
        }

        setMonthlyConsumption(people, Constants.DAYS_IN_MONTH, Constants.NO_OF_LITRES_PER_DAY);
    }

    public void addGuest(int guests){
        this.guests += guests;
        waterConsumedByGuests += guests * Constants.NO_OF_LITRES_PER_DAY * Constants.NO_OF_LITRES_PER_DAY;
    }


    public int getGuets(){
        return guests;
    }

    public void setMonthlyConsumption(int people, int days, int litre){
        monthlyConsumption += people*days*litre;
    }

    public int getTotalPeople(){
        return people+guests;
    }
    
}
