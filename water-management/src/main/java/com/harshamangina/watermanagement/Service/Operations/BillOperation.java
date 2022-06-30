package com.harshamangina.watermanagement.Service.Operations;

import java.util.StringJoiner;

import com.harshamangina.watermanagement.Entity.Apartment;
import com.harshamangina.watermanagement.Service.BillService.BillServiceForBoreWell;
import com.harshamangina.watermanagement.Service.BillService.BillServiceForCorporation;
import com.harshamangina.watermanagement.Service.BillService.BillServiceForTank;

public class BillOperation {

    
    private Apartment apartment;

    //Constructor based injection of dependency(as we can't preoduce a bill unless there is an apartment).
    public BillOperation(Apartment apartment){
        this.apartment = apartment;
    }

    public String generateBill(){
        Double TotalBill = 0.0;
        StringJoiner bill = new StringJoiner(" ");
        bill.add(apartment.getTotalWaterComsumed().toString());

        //Bill for BoreWell.
        TotalBill += new BillServiceForBoreWell(apartment.getTotalGuets() + apartment.getTenanatsInApartment(), apartment.getTotalWaterComsumed(), 
                                                apartment.getConsumptionPerMonth(), apartment.getBorewellShare(), apartment.getCorporationShare()).getBill();

        //Bill for Corporation .                                       
        TotalBill += new BillServiceForCorporation(apartment.getTotalGuets() + apartment.getTenanatsInApartment(), apartment.getTotalWaterComsumed(), 
                                                   apartment.getConsumptionPerMonth(), apartment.getBorewellShare(), apartment.getCorporationShare()).getBill();

        //Bill for Tank water.
        TotalBill += new BillServiceForTank(apartment.getTotalGuets() + apartment.getTenanatsInApartment(), apartment.getTotalWaterComsumed(), 
                                            apartment.getConsumptionPerMonth(), apartment.getBorewellShare(), apartment.getCorporationShare()).getBill();


        //Ceiling to nearest integer.
        bill.add(Integer.toString((int) Math.ceil(TotalBill)));
        
        return bill.toString();
        
    }

}
