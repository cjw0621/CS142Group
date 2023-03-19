import java.util.Scanner;

public class HotelConfiguration {

    private final static Scanner input = new Scanner(System.in);

    public static void config(){

            System.out.println(
                    "*********************************************\n"+
                    "* Welcome to the Hotel Configuration Portal *\n" +
                    "*********************************************\n\n");

            while (SignInClass.successEM){
                if(SignInClass.successMA){
                    break;
                }
                System.out.println("*Please Sign-In as a Manager to Continue*\n\n");
                SignInClass.signIn();
            }










    }

}
