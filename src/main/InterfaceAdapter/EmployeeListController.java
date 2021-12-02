package main.InterfaceAdapter;

import main.UsesCases.IEmployeeList;

public class EmployeeListController {

    private final IEmployeeList employeeList;

    public  EmployeeListController(IEmployeeList employeeList){
        this.employeeList = employeeList;
    }

    public void addEmployee(String department, String wage, String position,  String level, String status, String name){
        this.employeeList.addEmployee(department, wage, position, level, status, name);
    }


    //=== Usage: FacadeSys Worker Case (vi) ====
    public void deleteEmployee(String id){
        this.employeeList.deleteEmployee(id);
    }
    // ==================================
}
