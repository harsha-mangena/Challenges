package com.nymble.assessment.Quantizer;

public interface Quantizer<T> {
    
    /**
     * @param currentSpeed
     * @return
     */
    public Integer quantize(T currentSpeed);

}
