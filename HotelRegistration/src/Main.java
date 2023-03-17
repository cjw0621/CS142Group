import java.util.Arrays;
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

        SignInClass.signIn();

        while(true){

            System.out.println("1: Check In/Out A Guest\n2: Check Available Rooms\n3: Configuration");
            String input = sc.nextLine();

            if(input.equals("1")){

            }
            else if(input.equals("2")){

            }
            else if(input.equals("3")){

            }
            else if(input.equals(exit)){

                break;
            }
        }
    }
}