package com.nymble.assessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.nymble.assessment.Exceptions.MyException;
import com.nymble.assessment.Quantizer.Quantizer;
import com.nymble.assessment.Quantizer.QuantizerImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuantizeTest {

    private Quantizer<Integer> implementor;
    private Integer actual; 

    @BeforeAll
    void getQuantizeImpl()
    {
        implementor = new QuantizerImpl();
    }

    @BeforeEach
    void setUp() throws MyException
    {
        ((QuantizerImpl) implementor).setRange(4);
        ((QuantizerImpl) implementor).setPreviousSpeed(27);
        ((QuantizerImpl) implementor).setPreviousThrottle(2);
    }
    
    /**
     * Test : This test should return previousThrottleLevel, as currentSpeed E [prevSpeed-range, prevSpeed+range]
     * @throws MyException
     */
    @Test 
    @DisplayName("Test for previous throttled Level")
    void testForPreviousThrottleLevel()
    {
        actual = implementor.quantize(31);
        assertEquals(2, actual);
    }

    /**
     * Test : This test should return updatedThrottleLevel, as currentSpeed !E [prevSpeed-range, prevSpeed+range]
     * @throws MyException
     */
    @Test
    @DisplayName("Test for update throttled Level")
    void testForUpdatedThrottleLevel()
    {
        //Actual ThrottleLevel will be 4.
        actual = implementor.quantize(34);
        assertNotEquals(3, actual);
    }

}
