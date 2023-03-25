import java.nio.file.Files;
import java.util.Scanner;

public class CheckInOut
{
    public static Scanner sc = new Scanner(System.in);
    private static String guestName;
    public static String pet_YESno;

    private static boolean petAllowed;
    public static String roomNumber;
    private static boolean cleanStatus;


    private static String petBREED;
    private static String dogBREED;
    private static int Number_Of_Adults;
    private static int Number_Of_Minors;
    private static int Number_Of_Days_Staying;
    private static int number_Of_Beds;
    private static int suiteLevel;
    private static double prices;

    //RoomObj(String guestName, int roomNumber, boolean petAllowed, int numberOfBeds, int suiteLevel, String cleanStatus,  double price){






    public static void guestCheckInOut()
    {

 //asking GUEST name
        System.out.print("\n\nPlease input GUEST NAME = ");
        guestName = sc.next();

//asking total NUMBER of Adults
        System.out.print("\n\nPlease input the number of ADULTS that will be staying at the hotel = ");
        int Number_Of_Adults = Integer.parseInt(sc.next());

//asking total NUMBER of Minors
        System.out.print("\n\nPlease input the total number of MINORS that will be staying at the hotel = ");
        int Number_Of_Minors = Integer.parseInt(sc.next());

 //asking NUMBER_of_DAYS_in_HOTEL
        System.out.print("\n\nPlease input the total number of DAYS staying at the hotel = ");
        int Number_Of_Days_Staying = Integer.parseInt(sc.next());

//RoomObj(String guestName, int roomNumber, boolean petAllowed, int numberOfBeds, int suiteLevel, String cleanStatus,  double price){

//inputting SUITE preference based also on Availability and Price
        System.out.print("\n\nPlease choose your ROOM preference from following Availabilities and Prices down below                                \n\n" +

       "        TYPES OF ROOMS                       PRICES          AVAILABILITIES      number Of BEDS                                             \n"+

       " (1) Regular Standard SUITE ROOMS: 2                                                                                                        \n"+
       " (2) Stand Alone ROOMS: 1                                                                                                                   \n"+
       " (3) Luxury Level SUITE_ROOMS: 3                                                                                                            \n"+
       " (4) Executive Level SUITE_ROOMS: 4                                                                                                         \n");


        guestName = sc.next();

//asking total NUMBER of Adults
 //       System.out.print("\n\nPlease input the number of ADULTS that will be staying at the hotel = ");
    //    int Number_Of_Adults = Integer.parseInt(sc.next());

//asking total NUMBER of Minors
  //      System.out.print("\n\nPlease input the total number of MINORS that will be staying at the hotel = ");
    //    int Number_Of_Minors = Integer.parseInt(sc.next());

        //asking NUMBER_of_DAYS_in_HOTEL
     //   System.out.print("\n\nPlease input the total number of DAYS staying at the hotel = ");
   //    int Number_Of_Days_Staying = Integer.parseInt(sc.next());







  //asking PET-info
        System.out.print("\n\nDid you bring any PETS??  ");
        System.out.print("\nEnter 'y' for YES; Enter 'n' for NO =");
        char hasPETS = sc.next().charAt(0);

        if (hasPETS == 'y')
        {
            pet_YESno = "YES";

//asking animal type
            System.out.print("\nPlease enter your PET breed = ");
            petBREED = sc.next();


//if animal type is "dog"
            if (petBREED.equals("dog"))
            {
//input 'breed' of "dog"
                System.out.print("\n\nPlease input your dog breed = ");
                dogBREED = sc.next();
//if 'breed' is "rottweiler"
                if (dogBREED.equals("rottweiler"))
                {
                    System.out.println("\n\nSorry! We no longer accept rottweilers inside the hotel, due to previous complications in the pasts");
                    System.out.println(" ");
                }
//if 'breed' not "rottweiler"
                else
                {
                }
            }
        }
            if(hasPETS =='n')
            {
                pet_YESno = "NO";
             }
            System.out.println("\n\nYOUR CHECK-IN SUMMARY");
            System.out.println("");
            System.out.println("Has a Pet? = " + pet_YESno);
            System.out.println("Total Number of People = " + (Number_Of_Adults+Number_Of_Minors));
            System.out.println("Total Number of Adults = " + Number_Of_Adults);
            System.out.println("Total Number of Minors = " + Number_Of_Minors);
            System.out.println("Total Number of Pets = 0");
            System.out.println("Total Number of Days staying at the Hotel = " + Number_Of_Days_Staying);
        }
}





