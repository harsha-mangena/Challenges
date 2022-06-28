package com.challenges;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.challenges.watermanagement.Exception.BillException;

public class inputParser {    

    /**
     * This method takes filePath as a parameter and return Map of commands and arguments.
     * Method : getCommands
     * @param filePath<String>
     * @return : List<String> of Commands
     */
    public List<String> getCommands(String filePath) throws BillException{

        //BufferedRedaer
        BufferedReader reader = null;
    
        List<String> commands = new ArrayList<>();
        try{
            File file =  new File(filePath);
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line=reader.readLine()) != null){
                commands.add(line);
            }
            reader.close();
        }
        catch(Exception e){
            throw new BillException("Error while parsing the input file, Please try again");
        }

        return commands;
    }

}