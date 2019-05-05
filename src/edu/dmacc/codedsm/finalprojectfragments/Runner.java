package edu.dmacc.codedsm.finalprojectfragments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Runner {
    static HashMap<String, String> hmap = new HashMap<>();
    static Double hoursWorked = 0.00d;
    static Double myDouble;
    static String updatedHoursEntered;
    static Double employeeRate;
    static String array1[];

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

    public static void promptToDisplay() throws IOException {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            System.out.println("Press 1 to list all employees.");
            System.out.println("Press 2 to update employee hours worked.");
            System.out.println("Press 3 to process payroll.");
            System.out.println("Press 4 to exit program.");
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
                            System.out.println("Employee id number: " + array1[0]);
                            System.out.println("Employee name: " + array1[1]);
                            System.out.println("Employee hourly rate: " + array1[2]);
                            System.out.println("Hours worked: " + hoursWorked);
                            System.out.println();

                        }
                        bufferReader.close();
                    } catch (Exception e) {
                        System.out.println("Error while reading file line by line:"
                                + e.getMessage());
                    }

                } else if (userAnswer.equals("2")) {
                    String fileName = "initial_load.txt";
                    try {
                        FileReader inputFile = new FileReader(fileName);
                        BufferedReader bufferReader = new BufferedReader(inputFile);
                        String line;

                        while ((line = bufferReader.readLine()) != null) {

                            String array1[] = line.split(",", 3);

                            System.out.println("Enter employee ID number: ");
                            String numberEntered = scanner.next();
                            if (hmap.containsKey(numberEntered)) {
                                Double employeeRate = Double.parseDouble(array1[0]);
                                System.out.println("Update employee hours by entering hours worked: ");
                                String updatedHoursEntered = scanner.next();
                                hmap.put(numberEntered, updatedHoursEntered);
                                Double myDouble = Double.parseDouble(updatedHoursEntered);
                                Double netPay = (myDouble * employeeRate) / 1.2;
                                System.out.println("Employee's net pay is : " + netPay);
                                break;


                                //System.out.println(hmap);
                            } else {
                                System.out.println("Employee not found.");
                            }
                            isRunning = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Error while reading file line by line:"
                                + e.getMessage());
                    }
                } else if (userAnswer.equals("3")) {
                    System.out.println("To process payroll for an employee, enter employee ID number: ");
                    String numberEntered = scanner.next();
                    if (hmap.containsKey(numberEntered)) {
                        Double employeeRate = Double.parseDouble(array1[2]);
                        System.out.println("Update employee hours by entering hours worked: ");
                        String updatedHoursEntered = scanner.next();
                        hmap.get(updatedHoursEntered);
                        Double myDouble = Double.parseDouble(updatedHoursEntered);
                        Double netPay = (myDouble * employeeRate) / 1.2;
                        System.out.println("Employee's net pay is : " + netPay);
                        System.out.println();
                    } else if (userAnswer.equals("4")) {
                        isRunning = false;
                    } else isRunning = true;
                }
            }
        }
    }
}

