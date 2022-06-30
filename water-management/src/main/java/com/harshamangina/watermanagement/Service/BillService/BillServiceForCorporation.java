package com.harshamangina.watermanagement.Service.BillService;

import com.harshamangina.watermanagement.Constants.Constants;

import lombok.NonNull;

public class BillServiceForCorporation extends BillService{

    public BillServiceForCorporation(@NonNull Integer totalPeople, @NonNull Integer totalWaterConsumed, @NonNull Integer consumptionPerMonth,
                                     @NonNull Integer boreWellShare, @NonNull Integer corporationShare){
                                        
        super(totalPeople, totalWaterConsumed, consumptionPerMonth, boreWellShare, corporationShare);
    }

    @Override
    public Double getBill() {
        return Constants.FLAT_CORPORATION_PRICE* getUnit() * getCorporationShare();
    }
    
}
