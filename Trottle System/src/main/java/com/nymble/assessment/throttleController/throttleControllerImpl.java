package com.nymble.assessment.throttleController;

import com.nymble.assessment.Exceptions.MyException;
import com.nymble.assessment.Quantizer.Quantizer;
import com.nymble.assessment.Quantizer.QuantizerImpl;

    /**
     * Assumptions : The vechile in Cruise Mode maintains the speed of/at cruiseSpeed
     * If the cruiseSpeed < currentSpeed, we have 2 options.
     * 1) set the cruiseSpeed to NULL, i.e vechle no longer in cruiseMode, or
     * 2) set the cruiseSpeed = currentSpeed
     * 
     * ----------------------------------------------------------------
     * We also implemented setRange() method in QuantizerImpl, which will be used to set the range for our hysteresis.
     * 
     */

public class throttleControllerImpl implements throttleController{

    private int cruiseSpeed;
    private Quantizer<Integer> quantizer = new QuantizerImpl();


    /**
     * This is a setter method for the cruiseSpeed.
     * @param cruiseSpeed Integer
     * @throws MyException
     */
    @Override
    public void setCruiseSpeed(Integer cruiseSpeed) throws MyException {
        if(cruiseSpeed == null)
        {
            throw new MyException("Error setCruiseSpeed : cruiseSpeed(Integer) is null");
        }
        this.cruiseSpeed = cruiseSpeed;
    }

    /**
     * THis Method is getter for cruiseSpeed 
     * @return cruiseSpeed Integer
     */
    public Integer getCruiseSpeed()
    {
        return this.cruiseSpeed;
    }

    /**
     * This method uses the Quantizer<Generic> implementation, for the calculation of the throttleLevel.
     * return the same trottle level if currentSpeed E [previousSpeed - range, previousSpeed + range], else updated throtte level.
     * We also have to update the currentSpeed, currentThrottleLevel for the further calculation of the throttleLevel. 
     * 
     * @param currentSpeed Integer
     * @throws MyException
     */

    @Override
    public Integer calculateThrottle(Integer currentSpeed) throws MyException {

        //Setting the range for our hysteresis.
        ((QuantizerImpl) quantizer).setRange(2);

        Integer Level = quantizer.quantize(currentSpeed);

        //Updating the previous Speed
        ((QuantizerImpl) quantizer).setPreviousSpeed(currentSpeed);

        //Updating the previous throttle Leve
        ((QuantizerImpl) quantizer).setPreviousThrottle(Level);

        return Level;   
    }
    
}
