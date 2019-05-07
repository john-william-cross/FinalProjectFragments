package edu.dmacc.codedsm.finalprojectfragments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import static edu.dmacc.codedsm.finalprojectfragments.Runner.hoursWorked;

public class DataLoaderController {

    public static void addToHashMap() {
         HashMap<String, String> hmap = new HashMap<>();

        String fileName = "initial_load.txt";
        try {
            FileReader inputFile = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(inputFile);
            String line;


            while ((line = bufferReader.readLine()) != null) {
                String firstChar = line.substring(0, line.indexOf(","));
                String restOfString = line.substring(line.indexOf(",") + 1);
                restOfString = restOfString + ", " + hoursWorked;
                hmap.put(firstChar, restOfString);

            }
            //System.out.println(hmap);
            //System.out.println(hmap.values());
            //System.out.println();
            bufferReader.close();
        } catch (Exception e) {
        }
    }

}

//Pam will create method for the initial data load