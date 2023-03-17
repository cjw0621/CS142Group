import java.util.Scanner;

public class SignInClass {
    private static final Scanner input = new Scanner(System.in);

    public static void signIn() {
        System.out.println("Hotel employee Sign-in: ");
        System.out.println("1) Sign-in\n2) Create new user");
        String userInput = input.nextLine();

        if (userInput.equals("1")) {
            System.out.print("Username: ");
            String username = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();
            //Create database query here

        } else if (userInput.equals("2")) {
            while (true) {
                System.out.println("Enter New Username: ");
                String username = input.nextLine();
                System.out.print("Enter A Password (Please add add at least 3 numbers and special characters): ");
                String password = input.nextLine();
                System.out.print("Is this employee a manager?: ");
                String isManager = input.nextLine();
                isManager = isManager.toLowerCase();
                if (isManager.equals("y") || isManager.equals("yes")) {
                    if(!EmployeeInfo.accountCreated) {
                        new EmployeeInfo(username, password, true);
                        if(EmployeeInfo.accountCreated) {
                            System.out.println("Account successfully created");

                            break;
                        }
                    }
                } else if (isManager.equals("n") || isManager.equals("no")) {
                    if(!EmployeeInfo.accountCreated) {
                        new EmployeeInfo(username, password, false);
                        if(EmployeeInfo.accountCreated) {
                            System.out.println("Account successfully created");
                            for (int i = 0; i < EmployeeInfo.employeeTracker.size(); i++) {
                                System.out.println(EmployeeInfo.employeeTracker.get(i));
                            }
                            break;
                        }
                    }

                } else {
                    System.out.println("Invalid response! Please try again.");
                }

            }
        }
    }


}
