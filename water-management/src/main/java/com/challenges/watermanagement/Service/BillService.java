package com.challenges.watermanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.challenges.watermanagement.Entity.Apartment;
import com.challenges.watermanagement.Entity.Community;

import lombok.Getter;
import lombok.NonNull;

public class BillService {

    private  Apartment apartment = new Apartment();

    @Getter @NonNull private  Integer totalWaterConsumed = 0;
    @Getter private int waterConsumedByGuest = 0;
    private int unitCost = 0;

    public BillService(){
        totalWaterConsumed += apartment.getMonthlyConsumption() + apartment.getWaterConsumedByGuests();
        waterConsumedByGuest += apartment.getWaterConsumedByGuests();
        System.out.println(totalWaterConsumed +" "+waterConsumedByGuest);
        unitCost = apartment.getMonthlyConsumption() / (apartment.getBoreWellShare() + apartment.getCorporationShare());
    }

    private Double getBillForGuest(){
        double billForGuest = 0.0;
        if(waterConsumedByGuest == 0){
            return billForGuest;
        }

        if (waterConsumedByGuest > 0) {
            billForGuest = waterConsumedByGuest * 2;
        }

        if (waterConsumedByGuest > 500) {
            billForGuest = 500 * 2 + (waterConsumedByGuest - 500) * 3;
        }
        
        if (waterConsumedByGuest > 1500) {
            billForGuest = 500 * 2 + 1000 * 3 + (waterConsumedByGuest - 1500) * 5;
        }
        
        if (waterConsumedByGuest > 3000) {
            billForGuest = 500 * 2 + 1000 * 3 + 1500 * 5 + (waterConsumedByGuest - 3000) * 8;
        }

        return billForGuest;
    } 

    public String getBill(){
        Double totalBill = Math.ceil(
            unitCost * apartment.getCorporationShare() * 1 + 
            unitCost * apartment.getBoreWellShare() * 1.5 + 
            getBillForGuest());

        return totalWaterConsumed.toString()+ " " + totalBill.toString();

    }
}

