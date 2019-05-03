package edu.dmacc.codedsm.finalprojectfragments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Runner {

    public static void main(String[] args) throws IOException {

        readFile();

        DisplayEmployeeInfo displayEmployeeInfo = new DisplayEmployeeInfo();

        System.out.println(displayEmployeeInfo);

    }

    public static void readFile() {
        HashMap<Integer, String> hmap = new HashMap<>();

        //Name of the file
        String fileName = "initial_load.txt";
        try {
            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);
            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);
            //Variable to hold the one line data
            String line;
            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null) {
                Integer firstChar = line.indexOf(0);
                String restOfString = line.substring(1);
                hmap.put(firstChar, restOfString);
            }
            //Close the buffer reader
            bufferReader.close();
            } catch (Exception e) {
        }
    }
}
