package com.harshamangina.watermanagement.Service.Operations;

import io.github.pixee.security.BoundedLineReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.harshamangina.watermanagement.Exception.serviceException;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
public class inputProcessor extends serviceException{
    @NonNull private String filePath;

    /**
     * This mathod takes file path as paramater and return the list of lines in input file.
     * @param : filePath <String>
     * @return : List<String> 
     */
    public List<String> getCommnadsFromFile() throws serviceException{
        List<String> inputCommands = new ArrayList<>();
        BufferedReader reader = null;
        File file = null;

        try{
            file = new File(this.filePath);
            reader = new BufferedReader(new FileReader(file));
            String line;
            while((line=BoundedLineReader.readLine(reader, 5_000_000))!=null){
                inputCommands.add(line);
            }

            //closing the bufferedReader.
            reader.close();
        }
        catch(IOException e){
            throw new serviceException("Cannot process the input file, please try again");
        }
        return inputCommands;
    }
}
