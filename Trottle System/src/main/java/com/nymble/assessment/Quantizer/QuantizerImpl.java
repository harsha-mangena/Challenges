package com.nymble.assessment.Quantizer;

import com.nymble.assessment.Exceptions.MyException;

public class QuantizerImpl implements Quantizer<Integer> {

    private Integer throttleLevel;
    private Integer previousSpeed;
    private Integer previousThrottleLevel;
    private int range;


    /**
     * This method is setter for current Speed as Previous Speed after excecution. 
     * 
     * @param previousSpeed Integer
     */
    public void setPreviousSpeed(Integer previousSpeed) {
        this.previousSpeed = previousSpeed;
    }

    /**
     * This method is setter for cuurent or previous Throttle Setter.
     * 
     * @param previousThrottle Integer
     */

    public void setPreviousThrottle(Integer previousThrottle) {
        this.previousThrottleLevel = previousThrottle;
    }

    /**
     * This is a setter method for the range, for our hysteresis.
     * 
     * @param range Integer
     * @throws MyException
     */
    public void setRange(Integer range) throws MyException
    {
        if(range == null)
        {
            throw new MyException("Error : range must not be null");
        }
        this.range = range;
    }

    /**
     * <p>
     * This methos is used to determine the accumulated throttle level for the given input speed. 
     * We have 7 throttle levels, from 1 to 7, each with a range.
     * If currentSpeed is ZERO or Negative Value, then the throttle level is 0.
     * 
     * 
     * @param currentSpeed
     * @return  Integer
     */

    public Integer getThrottleLevel(Integer currentSpeed)
    {
        // 1- 10 
        if(currentSpeed > 0 && currentSpeed <= 10) return 1;
        //11 - 20
        else if(currentSpeed > 10 && currentSpeed <= 20) return 2;
        //21 - 30
        else if(currentSpeed > 20 && currentSpeed <= 30) return 3;
        //31 - 40
        else if(currentSpeed > 30 && currentSpeed <= 40) return 4;
        //41 - 50
        else if(currentSpeed > 40 && currentSpeed <= 50) return 5;
        //51 -60
        else if(currentSpeed > 50 && currentSpeed <= 60) return 6;
        // > 60
        else if(currentSpeed >= 60) return 7;
        return 0; 
    }

    /**
     * This method, based on the hyteresis along with the range. Return true if the current Speed lies in [previousSpeed - range, previousSpeed + range], else false.
     * 
     * @param currentSpeed
     * @return boolean Based on our hysteresis
     */

    public boolean IsInRange(Integer currentSpeed)
    {
        if(previousSpeed != null && previousSpeed-range <= currentSpeed && currentSpeed <= previousSpeed+range){ 
            return true;
        }
        return false;
    }

    /**
     * This method takes current speed as a parameter and calculates the throttle level.
     * Checking if the current Speed in the range, by  using IsInRange().
     * If true, we will return previousThrottleLevel
     * else we will return newly calculated throttle level.
     * 
     * @return Integer throttle Level
     */

    @Override
    public Integer quantize(Integer currentSpeed) {


        if(!IsInRange(currentSpeed))
        {
            throttleLevel = getThrottleLevel(currentSpeed);
            return throttleLevel;
        }

        return previousThrottleLevel; 
    }
    
}
