import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exit = "//";
        final File HOTEL_DB_FILE = new File("HotelDB.txt");


        System.out.println("Welcome!\n");

        while(!SignInClass.successEM && !SignInClass.successMA){

            //Calls the SignInClass.signIn method to prompt user to first sign in or to create an account.
            System.out.println("------------------------");
            System.out.println("Hotel Employee Sign-In:");
            System.out.println("------------------------");
            System.out.print("1) Sign-In\n2) Create New User\n>> ");
            String userInput = sc.nextLine();

            if(userInput.equals("1")){

                SignInClass.signIn();
                if(!HOTEL_DB_FILE.exists()){

                    System.out.println("\nLets Configure Your Hotel: \n");
                    HotelConfiguration.config();

                }

            }else if(userInput.equals("2")){

                SignInClass.createLogin();

            }
        }

        while(true){

            System.out.print("\n1: Check In/Out A Guest\n2: Check Available Rooms\n3: To Find A Guest Or Guest Room" +
                    "\n4: Configuration\nType '//' to Exit\n>> ");

            String input = sc.nextLine();

            if(input.equals("1")){


                System.out.println("\n1: Check-In A Guest\n2: Check-Out A Guest");
                String chkInOrOut = sc.nextLine();

                if (chkInOrOut.equalsIgnoreCase("1")) {
                    CheckInOut.guestCheckIn();

                } else if (chkInOrOut.equalsIgnoreCase("2")) {
                    CheckInOut.guestCheckOut();

                } else if(chkInOrOut.equalsIgnoreCase("//")){
                    break;
                }
                else {
                    System.out.println("Response Was Not Recognized! Try Again!");
                }


            }else if(input.equals("2")){

               CheckRoom.getVacantRoom();

            }else if(input.equals("3")){

                System.out.print("\nPlease Enter Guests Name Or Room Number: \n>>");
                input = sc.nextLine();

                if(HotelConfiguration.isNum(input)){
                   int roomNum = HotelConfiguration.stringToInt(input);
                   CheckRoom.findGuest(roomNum);
                }else{
                    CheckRoom.findGuestRoom(input);
                }

            }

            else if(input.equals("4")){

                HotelConfiguration.config();

            } else if(input.equals(exit)){

                break;
            }
        }
    }

}