package com.nymble.assessment;

import io.github.pixee.security.BoundedLineReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class inputParser {
    
    /**
     * This method takes path for the input file containing the current speeds as input
     * Integers in the input file can be Positive ans Negative
     * This method throws an error if the input file contains NULL
     * 
     *  
     * @param path The path to the input file in resource directory
     * @return     List<Integer> The current speed parsed from input file
     * @throws IOException If the input file path not found, throws FileNotFoundException(String message)
     */

    public List<Integer> getInput(String path) throws IOException 
    {
        List<Integer> currentSpeeds = new ArrayList<Integer>();
        try{
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = BoundedLineReader.readLine(bufferedReader, 5_000_000)) != null)
            {
                Integer speed = Integer.parseInt(line);
                currentSpeeds.add(speed);
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            throw new FileNotFoundException("File Not Found, Please check the path of the file");
        }
        return currentSpeeds;
    }
}
