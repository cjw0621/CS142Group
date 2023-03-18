import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exit = "//";

        while(true) {
            System.out.println("Welcome!\nPress Enter:");
            String userInput = sc.nextLine();

            if(userInput.equals("") || userInput.equals(" ")){

                break;
            }
        }

        //Calls the SignInClass.signIn method to prompt user to first sign in or to create an account.

        SignInClass.signIn();

        while(true){

            System.out.print("1: Check In/Out A Guest\n2: Check Available Rooms\n3: Configuration\n>> ");
            String input = sc.nextLine();

            if(input.equals("1")){
                //insert check in and check out method here

            }
            else if(input.equals("2")){
                //insert check available room method here

            }
            else if(input.equals("3")){
                //insert configuration method here

            }
            else if(input.equals(exit)){

                break;
            }
        }
    }
}