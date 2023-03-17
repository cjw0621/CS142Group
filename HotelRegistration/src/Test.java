
public class Test {

    public static void main(String[] args) {

        SignInClass.signIn();

        for(int i = 0; i < EmployeeInfo.employeeTracker.size(); i++){
            System.out.println(EmployeeInfo.employeeDB.get(EmployeeInfo.employeeTracker.get(i)));
        }



    }
}
