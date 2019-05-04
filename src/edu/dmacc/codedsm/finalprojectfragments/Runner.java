package edu.dmacc.codedsm.finalprojectfragments;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Runner {
   static HashMap<String, String> hmap = new HashMap<>();

    public static void main(String[] args) throws IOException {



        addToHashMap();
        promptToDisplay();


    }
    public static void addToHashMap() {

        String fileName = "initial_load.txt";
        try {
            FileReader inputFile = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(inputFile);
            String line;


            while ((line = bufferReader.readLine()) != null) {
            String firstChar = line.substring(0,line.indexOf(","));
            String restOfString = line.substring(line.indexOf(",") + 1);
            hmap.put(firstChar, restOfString + ", hours worked: 0");

            }
            System.out.println(hmap);
            System.out.println();
            bufferReader.close();
        } catch (Exception e) {
        }
    }

    public static void promptToDisplay() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            System.out.println("Press 1 to list all employees. Press 2 to update employee hours worked. Press 3 to process payroll. Press 4 to exit program.");
            String userAnswer = scanner.next();
            {
                if (userAnswer.equals("1")) {
                    String fileName = "initial_load.txt";
                    try {
                        FileReader inputFile = new FileReader(fileName);
                        BufferedReader bufferReader = new BufferedReader(inputFile);
                        String line;
                        while ((line = bufferReader.readLine()) != null) {
                            String array1[] = line.split(",", 3);
                            for (String temp : array1) {
                                System.out.println(temp);
                            }
                        }
                        bufferReader.close();
                    } catch (Exception e) {
                        System.out.println("Error while reading file line by line:"
                                + e.getMessage());
                    }
                    isRunning = false;
                } else if (userAnswer.equals("2")) {

                } else if (userAnswer.equals("3")) {

                } else if (userAnswer.equals("4")) {
                    isRunning = false;
                } else isRunning = true;
            }
        }
    }
}


