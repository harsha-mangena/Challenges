package com.nymble.assessment;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.nymble.assessment.Exceptions.MyException;
import com.nymble.assessment.throttleController.throttleController;
import com.nymble.assessment.throttleController.throttleControllerImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ControllerTest {

    private throttleController controller;

    @BeforeAll
    void setUp()
    {
        controller = new throttleControllerImpl();
    }

    /**
     * Test : This test will throw an exception, when cruiseSpeed is set to NULL
     * @throws MyException 
     */
    @Test 
    @DisplayName("Test for set Cruise Speed")
    void testSetCruiseSpeed() throws MyException
    {
        assertThrows(MyException.class, () -> {controller.setCruiseSpeed(null);});
    }
    
}
