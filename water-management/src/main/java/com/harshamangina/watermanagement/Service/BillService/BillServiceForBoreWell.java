package com.harshamangina.watermanagement.Service.BillService;

import com.harshamangina.watermanagement.Constants.Constants;

import lombok.NonNull;

public class BillServiceForBoreWell extends BillService{

    public BillServiceForBoreWell(@NonNull Integer totalPeople, @NonNull Integer totalWaterConsumed, @NonNull Integer consumptionPerMonth,
                                  @NonNull Integer boreWellShare, @NonNull Integer corporationShare){
                                    
        super(totalPeople, totalWaterConsumed, consumptionPerMonth, boreWellShare, corporationShare);
    }

    @Override
    public Double getBill() {
        return Constants.FLAT_BOREWELL_PRICE* getUnit() * getBorewellShare();
    }
    
}
