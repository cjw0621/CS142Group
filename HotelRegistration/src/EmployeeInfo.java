import java.util.HashMap;
import java.util.LinkedList;

/*
This class creates an employee username and password if password created is valid, field boolean created Account is
used to verify that employee account was created.
*/
public class EmployeeInfo {
    private String username;
    private String password;
    public static boolean accountCreated = false;
    public static final HashMap<String, String> employeeDB = new HashMap<>();
    public static final HashMap<String, String> managerDB = new HashMap<>();
    public static  LinkedList <String> employeeTracker = new LinkedList<>();


    public EmployeeInfo(String username, String password, boolean isManager) {

            if(passCheck(password)){
                setUsername(username);
                setPassword(password);
                setEmployeeDB(username, password, isManager);
                setEmployeeTracker(username);
                accountCreated = true;

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

        for(int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (password.contains(symbol[i]) && password.contains(numbers[j])) {
                    count++;
                }
            }
        }

        if(count >= 3){
            this.password = password;
            return true;

        } else {

            System.out.println("Password not strong enough!\nYou must add at least 3 numbers and special characters " +
                    "to your password");
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
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
