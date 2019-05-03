package edu.dmacc.codedsm.finalprojectfragments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Runner {

    public static void main(String[] args) throws IOException {
        addToHashMap();
        promptToDisplay();


    }

    public static void addToHashMap() {
        HashMap<Integer, String> hmap = new HashMap<>();
        String fileName = "initial_load.txt";
        try {
            FileReader inputFile = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(inputFile);
            String line;


            while ((line = bufferReader.readLine()) != null) {
                Integer firstChar = line.indexOf(0);
                String restOfString = line.substring(2, line.length()-1);
                hmap.put(firstChar, restOfString);

            }
            bufferReader.close();
        } catch (Exception e) {
        }
    }

    public static void promptToDisplay() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            System.out.println("Press 1 to list all employees. Press 2 to exit program.");
            String listEmployeesOrNot = scanner.next();
            {
                if (listEmployeesOrNot.equals("1")) {
                    String fileName = "initial_load.txt";
                    try {
                        FileReader inputFile = new FileReader(fileName);
                        BufferedReader bufferReader = new BufferedReader(inputFile);
                        String line;
                        while ((line = bufferReader.readLine()) != null) {
                            System.out.println("Data is: " + line + ", 0");
                        }
                        bufferReader.close();
                    } catch (Exception e) {
                        System.out.println("Error while reading file line by line:"
                                + e.getMessage());
                    }
                    isRunning = false;
                } else if (listEmployeesOrNot.equals("2")) {
                    isRunning = false;
                } else isRunning = true;
            }
        }
    }
}


