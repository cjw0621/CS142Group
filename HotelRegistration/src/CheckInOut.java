import java.util.Scanner;

public class CheckInOut
{
    public static Scanner sc = new Scanner(System.in);
    private static String guestName;
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
        System.out.print("Please input GUEST NAME = ");
        guestName = sc.next();

        System.out.print("Did you bring any PETS??  ");
        System.out.print("Enter 'y' for YES; ");
        System.out.print("Enter 'n' for NO = ");
        char hasPETS = sc.next().charAt(0);


        if (hasPETS == 'y')
        {

            System.out.print("Please enter your PET breed = ");
            petBREED = sc.next();


            if (petBREED.equals("dog"))
            {
                System.out.print("Please input your dog breed = : ");
                dogBREED = sc.next();

                if (dogBREED.equals("rottweiler"))
                {
                    System.out.println("Sorry! We no longer accept rottweilers inside the hotel, due to previous complications in the pasts");
                    System.out.println(" ");
                }

                else
                {
                    System.out.print("Please input the number of adults that will be staying at the hotel = ");
                    int Number_Of_Adults = Integer.parseInt(sc.next());

                    System.out.print("Please input the total number of minors that will be staying at the hotel = ");
                    int Number_Of_Minors = Integer.parseInt(sc.next());

                    System.out.print("Please input the total number of days staying at the hotel = ");
                    int Number_Of_Days_Staying = Integer.parseInt(sc.next());


                    System.out.println("YOUR CHECK-IN SUMMARY");
                    System.out.println("");
                    System.out.println("Has a Pet? = YES");
                    System.out.println("Type of Pet = " + petBREED);
                    System.out.println("Dog Breed = " + dogBREED);
                    System.out.println("Total Number of People = " + (Number_Of_Adults+Number_Of_Minors));
                    System.out.println("Total Number of Adults = " + Number_Of_Adults);
                    System.out.println("Total Number of Minors = " + Number_Of_Minors);
                    System.out.println("Total Number of Days staying at the Hotel = " + Number_Of_Days_Staying);
                }
            }
        }

        if(hasPETS =='y' && !dogBREED.equals("rottweiler") && petBREED.equals("dog")) {
            System.out.print("Please input the number of adults that will be staying at the hotel = ");
            int Number_Of_Adults = Integer.parseInt(sc.next());

            System.out.print("Please input the total number of minors that will be staying at the hotel = ");
            int Number_Of_Minors = Integer.parseInt(sc.next());

            System.out.print("Please input the total number of days staying at the hotel = ");
            int Number_Of_Days_Staying = Integer.parseInt(sc.next());


            System.out.println("YOUR CHECK-IN SUMMARY");
            System.out.println("");
            System.out.println("Has a Pet? = NO");
            System.out.println("Total Number of People = " + (Number_Of_Adults+Number_Of_Minors));
            System.out.println("Total Number of Adults = " + Number_Of_Adults);
            System.out.println("Total Number of Minors = " + Number_Of_Minors);
            System.out.println("Total Number of Pets = 0");
            System.out.println("Total Number of Days staying at the Hotel = " + Number_Of_Days_Staying);

        }

        if (hasPETS =='n'){
            System.out.print("Please input the number of adults that will be staying at the hotel = ");
            int Number_Of_Adults = Integer.parseInt(sc.next());

            System.out.print("Please input the total number of minors that will be staying at the hotel = ");
            int Number_Of_Minors = Integer.parseInt(sc.next());

            System.out.print("Please input the total number of days staying at the hotel = ");
            int Number_Of_Days_Staying = Integer.parseInt(sc.next());


            System.out.println("YOUR CHECK-IN SUMMARY");
            System.out.println("");
            System.out.println("Has a Pet? = NO");
            System.out.println("Total Number of People = " + (Number_Of_Adults+Number_Of_Minors));
            System.out.println("Total Number of Adults = " + Number_Of_Adults);
            System.out.println("Total Number of Minors = " + Number_Of_Minors);
            System.out.println("Total Number of Pets = 0");
            System.out.println("Total Number of Days staying at the Hotel = " + Number_Of_Days_Staying);

        }
    }

}
