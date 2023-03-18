import java.util.HashMap;
import java.util.Scanner;

public class SignInClass {
    private static final Scanner input = new Scanner(System.in);

    public static void signIn() {

        HashMap<String,String > readEmployeeDB = Database.readEmployeeDBFile(false);
        HashMap<String, String> readManagerDB = Database.readEmployeeDBFile(true);

        while (true) {
            if (EmployeeInfo.accountCreated) {
                System.out.println("Account Successfully Created");
                EmployeeInfo.accountCreated = false;
            }

            System.out.println("------------------------");
            System.out.println("Hotel Employee Sign-In:");
            System.out.println("------------------------");
            System.out.print("1) Sign-In\n2) Create New User\n>> ");
            String userInput = input.nextLine();


            if (userInput.equals("1")) {
                System.out.print("Username: \n>>");
                String username = input.nextLine();

                System.out.print("Password: \n>>");
                String password = input.nextLine();

                if (readEmployeeDB.containsKey(username) && readEmployeeDB.get(username).equals(password)) {

                    System.out.println("Welcome " + username);

                } else if (readManagerDB.containsKey(username) && readManagerDB.get(username).equals(password)) {

                    System.out.println("Welcome " + username);


                } else {

                System.out.println("Incorrect username or password. Please try again, or create an account.");

                }

                break;


            } else if(userInput.equals("2")) {

                String username;

                System.out.print("Enter New Username: \n>>");
                username = input.nextLine();

                System.out.print("Enter A Password (Please add add at least 3 numbers and or special characters): \n>>");
                String password = input.nextLine();

                System.out.print("Is This Employee A Manager? \n>>");
                String isManager = input.nextLine();

                isManager = isManager.toLowerCase();


                if(isManager.equals("y") || isManager.equals("yes")) {

                    if(!EmployeeInfo.accountCreated) {

                        new EmployeeInfo(username, password, true);
                    }

                } else if(isManager.equals("n") || isManager.equals("no")) {

                    if(!EmployeeInfo.accountCreated) {

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
