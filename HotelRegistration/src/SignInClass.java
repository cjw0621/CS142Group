import java.util.HashMap;
import java.util.Scanner;

public class SignInClass {
    private static final Scanner input = new Scanner(System.in);
    public static boolean successEM = false;
    public static boolean successMA = false;

    public static void signIn() {

        System.out.print("Username: \n>> ");
        String username = input.nextLine();

        System.out.print("Password: \n>> ");
        String password = input.nextLine();

        HashMap<String,String > readEmployeeDB = Database.readEmployeeDBFile(false);
        HashMap<String, String> readManagerDB = Database.readEmployeeDBFile(true);

        if (readEmployeeDB.containsKey(username) &&
                readEmployeeDB.get(username).equals(password)) {

            System.out.println("Welcome " + username + "!");
           successEM = true;
           successMA = false;

        } else if (readManagerDB.containsKey(username) &&
                readManagerDB.get(username).equals(password)) {

            System.out.println("Welcome " + username + "!");
            successMA = true;
            successEM = false;
        }

       else {

        System.out.println("Incorrect username or password. Please try again, or create an account.");

        }

    }


    public static void createLogin() {

        String username;

        while (true) {
            System.out.print("Enter New Username: \n>> ");
            username = input.nextLine();

            System.out.print("Enter A Password (Please add add at least 3 numbers and or special characters): \n>> ");
            String password = input.nextLine();

            System.out.print("Is This Employee A Manager? \n>> ");
            String isManager = input.nextLine();

            isManager = isManager.toLowerCase();


            if (isManager.equals("y") || isManager.equals("yes")) {

                if (!EmployeeInfo.accountCreated) {

                    new EmployeeInfo(username, password, true);
                    Database.writeEmployeeDBtoTxt();

                }

            } else if (isManager.equals("n") || isManager.equals("no")) {

                if (!EmployeeInfo.accountCreated) {

                    new EmployeeInfo(username, password, false);
                    Database.writeEmployeeDBtoTxt();

                }

            } else {

                System.out.println("Invalid Response. Please use either 'y' or 'n'.");
            }

            if (EmployeeInfo.accountCreated) {
                System.out.println("Account Successfully Created");
                EmployeeInfo.accountCreated = false;
                break;
            }
        }
    }


}
