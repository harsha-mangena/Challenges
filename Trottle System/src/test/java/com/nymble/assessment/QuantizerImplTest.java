package com.nymble.assessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.nymble.assessment.Exceptions.MyException;
import com.nymble.assessment.Quantizer.QuantizerImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuantizerImplTest {

    private QuantizerImpl quantizer; 
    private Integer Level;
    
    @BeforeAll
    public void setUp()
    {
        quantizer = new QuantizerImpl();
    }


    /**
     * Test : This test case should throw MyException, when we set range as NULL value in QuantizerImpl. 
     * @throws MyException
     */

    @Test
    @DisplayName("Test for Invalid Range Exception")
    void testInvalidRangeException() throws MyException {
        assertThrows(MyException.class, () -> {quantizer.setRange(null);});
    }


    /**
     * Test : This test case checks if the current Speed, lies ines in the [prevSpeed-range, prevSpeed+range].
     * @throws MyException
     */
    @Test 
    @DisplayName("Test for currentSpeed IsInRange")
    void testIsInRange_true() throws MyException
    {
        quantizer.setRange(1);
        quantizer.setPreviousSpeed(10);
        assertEquals(false, quantizer.IsInRange(12));
    }


    /**
     * Test : This test should return the anticipated throttle Level for given current speed.
     * @throws MyException
     */
    @Test 
    @DisplayName("Test for Throttle level") 
    void testThrottleLevel()
    {
        Level = quantizer.getThrottleLevel(65);
        assertEquals(7, Level);
    }
    
}
