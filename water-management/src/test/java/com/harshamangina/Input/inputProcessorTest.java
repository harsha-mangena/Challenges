package com.harshamangina.Input;

import com.harshamangina.watermanagement.Exception.serviceException;
import com.harshamangina.watermanagement.Service.Operations.inputProcessor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;

@TestInstance(Lifecycle.PER_CLASS)
public class inputProcessorTest {
    
    @Mock
    inputProcessor processor;

    @BeforeAll
    void setUp(){
    }

    @Test
    void testFor_ValidInputFile() throws serviceException{
        processor = new inputProcessor("src/test/java/com/harshamangina/test_input.txt");
        List<String> cmds = processor.getCommnadsFromFile();
        assertEquals(3, cmds.size());
    }

    @Test
    void testFor_InvalidInputFile(){
        processor = new inputProcessor();
        assertThrows(NullPointerException.class, () -> processor.getCommnadsFromFile());
    }
}
