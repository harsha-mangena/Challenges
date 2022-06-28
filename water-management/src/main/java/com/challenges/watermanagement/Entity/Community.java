package com.challenges.watermanagement.Entity;

import org.springframework.lang.NonNull;

import com.challenges.watermanagement.Constants.Constants;

import lombok.Getter;


@Getter
public abstract class Community {
    @Getter @NonNull private int NoOfDays = Constants.DAYS_IN_MONTH;
    @Getter @NonNull private int ConsumptionPerDay = Constants.NO_OF_LITRES_PER_DAY;
    @Getter private int boreWellShare;
    @Getter private int corporationShare;

    public void InitializeCommunity(@NonNull Integer boreWellShare, @NonNull Integer corporationShare){
        this.boreWellShare = boreWellShare;
        this.corporationShare = corporationShare;
    }
}
