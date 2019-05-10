package edu.dmacc.codedsm.finalprojectfragments;


public class DataLoaderController {

    public static void loadEmployeeData(){
        DataLoaderService.readFile();
    }

    EmployeeRepository employeeRepository = new EmployeeRepository();
}