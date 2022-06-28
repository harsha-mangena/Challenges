package com.nymble.assessment.throttleController;

import com.nymble.assessment.Exceptions.MyException;

public interface throttleController {

    /**
     * This method is setter for cruiseSpeed
     * @param cruiseSpeed
     * @throws MyException
     */
    public void setCruiseSpeed(Integer cruiseSpeed) throws MyException;

    /**
     * This is method have dependency on the QuantizerImpl, to calculate the throttleSpeed
     * @param currentSpeed
     * @return throttleLevel Integer
     * @throws MyException
     */
    public Integer calculateThrottle(Integer currentSpeed) throws MyException;
    
}
