import java.util.HashMap;
import java.util.LinkedList;

/*
This class creates an employee username and password if password created is valid, field boolean created Account is
used to verify that employee account was created.
*/
public class EmployeeInfo {
    private static String username;
    private static String password;
    public static boolean isManager = false;
    public static boolean accountCreated = false;
    public static HashMap<String, String> employeeDB = new HashMap<>();
    public static HashMap<String, String> managerDB = new HashMap<>();
    public static  LinkedList <String> employeeTracker = new LinkedList<>();
    public static int employeeCounter = 0;


    public EmployeeInfo(String username, String password, boolean isManager) {

        if(passCheck(password)){
                setUsername(username);
                setPassword(password);
                setIsManager(isManager);
                setEmployeeDB(username, password, isManager);
                setEmployeeTracker(username);
                accountCreated = true;
                employeeCounter++;

            } else {
                System.out.println("Account failed to be created.");
                accountCreated = false;
            }
    }

    public boolean passCheck(String password){
        String[] symbol = {"!", "@", "#", "$", "%", "^","&","*"};
        String[] numbers = new String[10];

        int count = 0;
        for(int i = 0; i < numbers.length; i++){
           String s = Integer.toString(i);
           numbers[i] = s;
        }

        for (String s : symbol) {
            for (String number : numbers) {
                if (password.contains(s) && password.contains(number)) {
                    count++;
                }
            }
        }

        if(count >= 3){
            EmployeeInfo.password = password;
            return true;

        } else {

            System.out.println("Password not strong enough!\nYou must add at least 3 numbers and special characters " +
                    "to your password");
            return false;
        }
    }

    public static String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        EmployeeInfo.username = username;
    }

    public static String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        EmployeeInfo.password = password;
    }
    private void setIsManager(boolean managerStatus){
        isManager = managerStatus;
    }

    private void setEmployeeDB(String username, String password, boolean isManager){
        if(!isManager) {
            employeeDB.put(username,password);
        } else {
            managerDB.put(username,password);
        }

    }

    private void setEmployeeTracker(String username){
        employeeTracker.add(username);
    }

}
