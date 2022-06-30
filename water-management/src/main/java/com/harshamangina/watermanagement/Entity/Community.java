package com.harshamangina.watermanagement.Entity;

import lombok.Getter;
import lombok.NonNull;

/**
 * author : harsha mangina
 */

@Getter
public abstract class Community {
    @NonNull private Integer corporationShare;
    @NonNull private Integer borewellShare;

    public void InitializeCommunity(@NonNull Integer corporationShare, @NonNull Integer borewellShare) {
        this.corporationShare = corporationShare;
        this.borewellShare = borewellShare;
    }
}
