package Uses_Cases;

import Entity.*;

import java.util.HashMap;
import java.util.Set;

public class Employee_Manager {
    private HashMap<Userable, Employee> employeeList;

    public Employee_Manager(){
        Userable init_admin = new User(1,0, "Admin", 0, "");
        Employee init_employee = new FullTimeEmployee("HR", "Admin",0, 1);
        this.employeeList = new HashMap<>();
        employeeList.put(init_admin,init_employee);

        }

    public boolean verifyAccountExist(int account, int password) {
        Set<Userable> keys = employeeList.keySet();
        for (Userable key : keys) {
            if (key.getAccount() == account && key.getPassword() == password) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyAuthority(int account, int password) {
        Set<Userable> keys = employeeList.keySet();
        for (Userable key : keys) {
            if (key.getAccount() == account && key.getPassword() == password) {
                if (employeeList.get(key).getLevel() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public void createEmployee(int accountNumber, int password, String name, int phone, String address, String status,
                               String department, String position, int wage, int level){
        Userable newUser = new User(accountNumber, password, name, phone, address);
        if(status.equals("P")) {
            Employee newEmployee = new PartTimeEmployee(department, position, wage, level);
        }
            Employee newEmployee = new FullTimeEmployee(department, position, wage, level);
        employeeList.put(newUser,newEmployee);
    }
}


