package main.Framework;

import main.InterfaceAdapter.FacadeSys;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreateUserUI {

    private final FacadeSys facadeSys;

    public CreateUserUI(FacadeSys facadeSys) {
        this.facadeSys = facadeSys;
    }


    public void run() {
        Scanner keyIn = new Scanner(System.in);
        boolean noExist = true;
        while (noExist){
            String[] WorkInfoArray = {"username", "password", "name", "phone", "address", "department", "wage",
                    "position", "level", "status"};
            String username, password, name, phone, address, department, wage, position, level, status;
            Map<Integer, String> user_info = new HashMap<>();
            int counter = 0;
            for(String each_work_info: WorkInfoArray){
                System.out.println("Please type the " + each_work_info + " of new user");
                String info = keyIn.nextLine();
                user_info.put(counter, info);
                counter ++;
            }
            boolean SuccessCreatNewUser= this.facadeSys.createUser(
                    user_info.get(0),
                    user_info.get(1),
                    user_info.get(2),
                    user_info.get(3),
                    user_info.get(4),
                    user_info.get(5),
                    user_info.get(6),
                    user_info.get(7),
                    user_info.get(8),
                    user_info.get(9));
            if (SuccessCreatNewUser){
                System.out.println(
                        "If you want to create another user, please type C. \n" +
                                " Otherwise, please type E to exist");
                String action = keyIn.nextLine();
                if(action.equalsIgnoreCase("E")){
                    noExist = false;
                }
            }
            else {
                System.out.println("You cannot create this level of the user! Please type again.");
            }
        }
    }
}