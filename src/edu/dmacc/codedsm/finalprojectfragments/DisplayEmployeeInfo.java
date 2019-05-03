package edu.dmacc.codedsm.finalprojectfragments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;


public class DisplayEmployeeInfo {
    boolean isRunning = true;
    HashMap<Integer, String> hmap = new HashMap<Integer, String>();

    {
        {
            while (isRunning) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Press 1 to list all employees. Press 2 to exit program.");
                String listEmployeesOrNot = scanner.next();
                {
                    if (listEmployeesOrNot.equals("1")) {


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

                                System.out.println("Data is: " + line);
                            }

                            //Close the buffer reader
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
}
