package edu.dmacc.codedsm.finalprojectfragments;

import java.util.Collection;
import java.util.HashMap;

public class EmployeeService {
    public static Collection<Employee> gatherEmployees() {
        HashMap<String, Employee> employees = EmployeeRepository.getEmployees();
       return  employees.values();

    }
}
