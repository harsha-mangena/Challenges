package com.harshamangina.watermanagement.Service.BillService;

import com.harshamangina.watermanagement.Constants.Constants;

import lombok.NonNull;

public class BillServiceForTank extends BillService{
    public BillServiceForTank(@NonNull Integer totalPeople, @NonNull Integer totalWaterConsumed, @NonNull Integer consumptionPerMonth,
                              @NonNull Integer boreWellShare, @NonNull Integer corporationShare){
      
        super(totalPeople, totalWaterConsumed, consumptionPerMonth, boreWellShare, corporationShare);
    }

    @Override
    public Double getBill() {

        double bill = 0.0;
        int guestConsumption = (getConsumptionPerMonth() == 900 ? getTotalPeople() - 3 : getTotalPeople() - 5)* Constants.MONTH_DAYS * Constants.ALLOTED_WATER_PER_DAY;

        if (guestConsumption > 0) {
            bill = guestConsumption * 2;
        }

        if (guestConsumption > 500) {
            bill = 500 * 2 + (guestConsumption - 500) * 3;
        }

        if (guestConsumption > 1500) {
            bill = 500 * 2 + 1000 * 3 + (guestConsumption - 1500) * 5;
        }

        if (guestConsumption > 3000) {
            bill = 500 * 2 + 1000 * 3 + 1500 * 5 + (guestConsumption - 3000) * 8;
        }

        return bill;
        
    }
}
