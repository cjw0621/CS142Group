import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String exit = "//";

        while(true){

            System.out.println("Welcome!\nPress Enter:");
            String userInput = sc.nextLine();

            if(userInput.equals("") || userInput.equals(" ")){

                break;
            }
        }

        while(!SignInClass.successEM && !SignInClass.successMA){

            //Calls the SignInClass.signIn method to prompt user to first sign in or to create an account.
            System.out.println("------------------------");
            System.out.println("Hotel Employee Sign-In:");
            System.out.println("------------------------");
            System.out.print("1) Sign-In\n2) Create New User\n>> ");
            String userInput = sc.nextLine();

            if(userInput.equals("1")){

                SignInClass.signIn();

            }else if(userInput.equals("2")){

                SignInClass.createLogin();

            }
        }

        while(true){

            System.out.print("1: Check In/Out A Guest\n2: Check Available Rooms\n3: To Find A Guest\n4: Configuration\nType '//' to " +
                    "Exit\n>> ");
            String input = sc.nextLine();

            if(input.equals("1")){

                CheckInOut.guestCheckInOut();

            }else if(input.equals("2")){

                CheckRoom.getVacantRoom();

            } else if(input.equals("3")){

                HotelConfiguration.config();

            } else if(input.equals(exit)){

                break;
            }
        }
    }

}