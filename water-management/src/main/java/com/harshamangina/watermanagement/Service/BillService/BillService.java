package com.harshamangina.watermanagement.Service.BillService;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BillService {

    @Getter @NonNull private Integer totalPeople;
    @Getter @NonNull private Integer totalWaterConsumed;
    @Getter @NonNull private Integer consumptionPerMonth;
    @Getter @NonNull private Integer borewellShare;
    @Getter @NonNull private Integer corporationShare;

    /**
     * This method will be implemented as per the specification of needs. 
     */
    public abstract Double getBill();

    /*
     * The ratio between the corporation and borewell is converted into unit.
     */
    public Double getUnit(){
        return 1.0 * consumptionPerMonth / (borewellShare+corporationShare);
    }

}
