package com.nymble.assessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class inputParserTest {
    private inputParser parser;

    @BeforeAll
    void setUp()
    {
        parser = new inputParser();
    }

    /**
     * Test : This test will throw File Not Found Exception when path of file is not Found.
     * We will be using an test_input_file here to test.
     * @throws FileNotFoundException
     */

    @Test
    @DisplayName("Test for throwing FileNotFoundException")
    void testForFNFException()
    {
        assertThrows(FileNotFoundException.class, 
                      () -> {parser.getInput("/src/input.txt");});
    }

    /**
     * Test : This test will check two ArrayList<Integer> or else ArrayList.size()
     * @throws IOException
     * @throws FileNotFoundException  
     */
    @Test
    @DisplayName("Test for Input file")
    void testForInputFile() throws IOException
    {
        List<Integer> inputSpeed = parser.getInput("src/main/resources/test_Input_speed.txt");

        assertEquals(3, inputSpeed.size());
        
    }

}
