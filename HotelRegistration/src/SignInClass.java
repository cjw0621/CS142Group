import java.util.Scanner;

public class SignInClass {
    private static final Scanner input = new Scanner(System.in);

    public static void signIn() {

        while (true) {
            if(EmployeeInfo.accountCreated) {
                System.out.println("Account successfully created");
                EmployeeInfo.accountCreated = false;
            }

            System.out.println("------------------------");
            System.out.println("Hotel employee Sign-in:");
            System.out.println("------------------------");
            System.out.print("1) Sign-in\n2) Create new user\n>> ");
            String userInput = input.nextLine();


            if (userInput.equals("1")) {
                System.out.print("Username: ");
                String username = input.nextLine();

                System.out.print("Password: ");
                String password = input.nextLine();

                if (Database.readDBFile(false).containsKey(username) &&
                        Database.readDBFile(false).get(username).equals(password)) {

                    System.out.println("Welcome! ");
                    break;

                } else {

                    System.out.println("Incorrect username or password. Please try again, or create an account.");

                }

            } else if (userInput.equals("2")) {

                String username;

                System.out.println("Enter New Username: ");
                username = input.nextLine();

                System.out.println("Enter A Password (Please add add at least 3 numbers and special characters): ");
                String password = input.nextLine();

                System.out.print("Is this employee a manager? ");
                String isManager = input.nextLine();

                isManager = isManager.toLowerCase();


                if (isManager.equals("y") || isManager.equals("yes")) {
                    if(!EmployeeInfo.accountCreated) {
                        new EmployeeInfo(username, password, true);
                    }

                } else if (isManager.equals("n") || isManager.equals("no")) {
                    if (!EmployeeInfo.accountCreated) {
                        new EmployeeInfo(username, password, false);
                    }

                }else{
                    System.out.println("Invalid Response. Please use either 'y' or 'n'.");
                }

            }

            Database.writeEmployeeDBtoTxt();

        }


    }

}
