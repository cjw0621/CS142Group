import java.util.HashMap;
import java.util.Scanner;

public class CheckInOut
{
    public static Scanner sc = new Scanner(System.in);
    private static String guestName;
    public static Boolean hasPets;
    private static String petBREED;
    private static String dogBREED;
    private static int Number_Of_Adults;
    private static int Number_Of_Minors;
    private static int Number_Of_Days_Staying;
    private static int suiteLevel;


    public static void guestCheckIn(){

 //asking GUEST name
        System.out.print("\n\nPlease input GUEST NAME = ");
        guestName = sc.nextLine();

 //asking NUMBER_of_DAYS_in_HOTEL
        System.out.print("\n\nPlease input the total number of DAYS staying at the hotel = ");
        String numOfDays = sc.nextLine();

        if(HotelConfiguration.isNum(numOfDays)) {
            Number_Of_Days_Staying = HotelConfiguration.stringToInt(numOfDays);
        }

//RoomObj(String guestName, int roomNumber, boolean petAllowed, int numberOfBeds, int suiteLevel, String cleanStatus,  double price){

//inputting SUITE preference based also on Availability and Price
        System.out.print("\n\nPlease choose your ROOM preference from following Availabilities and Prices down below                                \n\n" +

       "        TYPES OF ROOMS                       PRICES          AVAILABILITIES      number Of BEDS                                             \n"+

       " (1) Regular Standard SUITE ROOMS: 2                                                                                                        \n"+
       " (2) Stand Alone ROOMS: 1                                                                                                                   \n"+
       " (3) Luxury Level SUITE_ROOMS: 3                                                                                                            \n"+
       " (4) Executive Level SUITE_ROOMS: 4                                                                                                         \n");


        suiteLevel = HotelConfiguration.stringToInt(sc.nextLine());

        System.out.print("\n\nDid you bring any PETS??  ");
        System.out.print("\nEnter 'y' for YES; Enter 'n' for NO =");
        char hasPETS = sc.next().charAt(0);

        if (hasPETS == 'y')
        {
            hasPets = true;

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
                hasPets = false;
             }
            System.out.println("\n\nYOUR CHECK-IN SUMMARY");
            System.out.println("");
            System.out.println("Has a Pet? = " + hasPets);
            System.out.println("Total Number of People = " + (Number_Of_Adults+Number_Of_Minors));
            System.out.println("Total Number of Adults = " + Number_Of_Adults);
            System.out.println("Total Number of Minors = " + Number_Of_Minors);
            System.out.println("Total Number of Pets = 0");
            System.out.println("Total Number of Days staying at the Hotel = " + Number_Of_Days_Staying);

            HashMap<Integer, RoomObj> roomObj = Database.readHotelDBTxt();

            for(int i = 0; i < roomObj.size(); i++){
                if(roomObj.get(i).getGuestName().equalsIgnoreCase("vacant") &&
                        roomObj.get(i).getSuiteLevel()==suiteLevel){

                    roomObj.get(i).setGuestName(guestName);
                    roomObj.get(i).setPrice(roomObj.get(i).getPrice() * Number_Of_Days_Staying);

                    System.out.println("Guest has been checked in!");
                    break;
                }
            }

            Database.writeHotelDBtoTxt(roomObj);

        }


        public static void guestCheckOut(){

            System.out.println("Please Enter The Guests Room Number To Check Them Out: ");
            String roomNum = sc.nextLine();

            if(HotelConfiguration.isNum(roomNum)) {

                int roomNumInt = HotelConfiguration.stringToInt(roomNum);

                GuestCheckInOut.checkGuestOut(roomNumInt);
            }



        }

}





