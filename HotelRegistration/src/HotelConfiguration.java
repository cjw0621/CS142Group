import java.util.*;
public class HotelConfiguration {
    private final static Scanner hotelInput = new Scanner(System.in);
    private static int maxNumOfRooms = 0;
    private static int standardNumBed = 0;
    private static boolean allRoomsPetFriendly = false;
    private static final List<Integer> PET_FRIENDLY_ROOMS = new ArrayList<>(0);
    private static final List<Integer> STANDARD_SUITE_ROOMS = new ArrayList<>(0);
    private static final List<Integer> LUXURY_LEVEL_SUITE_ROOMS = new ArrayList<>(0);
    private static final List<Integer> EXECUTIVE_LEVEL_SUITE_ROOMS = new ArrayList<>(0);
    private static int levelTwoSuites = 0;
    private static int levelThreeSuites = 0;
    private static int levelFourSuites = 0;
    private static double priceStandardRoom = 0.0;
    private static double priceMidRoom = 0.0;
    private static double priceLuxuryRoom = 0.0;
    private static double priceExecutiveRoom = 0.0;
    public static HashMap<Integer, RoomObj> hotelRoom = new HashMap<>(0);

    private static boolean isNum(String ui){

        int counter = 0;
        String ltr = "abcdefghijklmnopqrstuvwxyz?><:!@#$%^&*()_+~`,/;'[]|{}-";
        String[] uiArr = ui.split("");
        String[] ltrArr = ltr.split("");

        for (String value : ltrArr) {
            for (String s : uiArr) {
                if (value.equals(s.toLowerCase())) {
                    counter++;
                }
            }
        }

        return counter == 0;
    }

    private static int stringToInt(String a){
        //Converts String type number into an Int type number.
        return Integer.parseInt(a);
    }

    public static double stringToDouble(String a){
        //Converts String type number into a Double type number.
        return Double.parseDouble((a));
    }

    public static void config() {
        System.out.println(
                "*********************************************\n" +
                        "* Welcome to the Hotel Configuration Portal *\n" +
                        "*********************************************\n" +
                        "To exit type '//'");


        while (SignInClass.successEM) {

            if (SignInClass.successMA) {

                break;
            }

            System.out.println("*Please Sign-In as a Manager to Continue*\n\n");
            SignInClass.signIn();
        }


        while (true) {
            System.out.print("\nPlease Enter the Number of Rooms Available for Guests:\n>> ");
            String ui = hotelInput.nextLine();
            if(isNum(ui)){
               maxNumOfRooms = stringToInt(ui);
               break;
            }else{
                System.out.println("Invalid Number of Rooms!\n");
            }
        }


        while(true) {

            System.out.print("Are Pets Allowed In All Rooms?\n(type either y or n)\n>>");
            String ui = hotelInput.nextLine();

            if (ui.equalsIgnoreCase("n") || ui.equalsIgnoreCase("no")) {

                System.out.print("Please Indicate Which Rooms are Pet Friendly. When finished type '-1' \n>> ");
                ui = hotelInput.nextLine();

                while (!allRoomsPetFriendly) {

                    if(isNum(ui)){

                        PET_FRIENDLY_ROOMS.add(stringToInt(ui));

                    }else{

                        System.out.println("Invalid Response");
                    }
                }

                break;

            } else if (ui.equalsIgnoreCase("y") || ui.equalsIgnoreCase("yes")) {

                allRoomsPetFriendly = true;

                break;

            }else if (ui.equalsIgnoreCase("//")) {

                break;

            }else{
                System.out.println("Invalid response!");
            }
        }


        while(true){

            System.out.print("How Many Beds Will Each Standard Rooms Have?\n>> ");
            String ui = hotelInput.nextLine();

            if(isNum(ui)){
                standardNumBed = stringToInt(ui);
                break;
            } else{
                System.out.println("Invalid Response!");
            }
        }

        while(true) {

            System.out.print("How Many Standard Size Suites Are Available To Guests?\n>> ");
            String ui = hotelInput.nextLine();
            if (isNum(ui)) {

                levelTwoSuites = stringToInt(ui);
                break;

            } else {

                System.out.println("Invalid Response!");
            }
        }
        while(true) {

            System.out.println("How Many Mid-Level Suites Are Available To Guests?\n>> ");
            String ui = hotelInput.nextLine();

            if (isNum(ui)) {

                levelThreeSuites = stringToInt(ui);
                break;

            } else {

                System.out.println("Invalid Response!");
            }
        }

        while (true){

            System.out.println("How Many Executive-Level Suites Are Available To Guests?");
            String ui = hotelInput.nextLine();

            if(isNum(ui)){

                levelFourSuites = stringToInt(ui);
                break;

            }else {

                System.out.println("Invalid Response!");
            }
        }

        while(levelTwoSuites != STANDARD_SUITE_ROOMS.size()){

            System.out.print("Please Indicate Which Rooms Are Standard Suites.\nType '-1' When finished\n>> ");
            String ui = hotelInput.nextLine();

            if(ui.equalsIgnoreCase("-1")){
                break;
            }else if(isNum(ui)){
                STANDARD_SUITE_ROOMS.add(stringToInt(ui));
            }else{
                System.out.println("Invalid Room Number!\n");
                System.out.println("Standard Suite Room Numbers Are currently: " + STANDARD_SUITE_ROOMS);
            }
        }


        while(levelThreeSuites != LUXURY_LEVEL_SUITE_ROOMS.size() ) {

            if (levelTwoSuites != 0) {
                System.out.print("Please Indicate Which Rooms Are Luxury-Level Suites.\nType '-1' When finished\n>> ");
                String ui = hotelInput.nextLine();

                if (ui.equalsIgnoreCase("-1")) {
                    break;
                } else if (isNum(ui)) {
                    LUXURY_LEVEL_SUITE_ROOMS.add(stringToInt(ui));
                } else {
                    System.out.println("Invalid Room Number!\n");
                    System.out.println("Luxury Room Numbers Are currently: " + LUXURY_LEVEL_SUITE_ROOMS);
                }

            } else {
                break;
            }
        }

        while(levelFourSuites != EXECUTIVE_LEVEL_SUITE_ROOMS.size()) {

            if (levelFourSuites != 0) {
                System.out.print("Please Indicate Which Rooms Are Executive-Level Suites.\nType '-1' When finished\n>> ");
                String ui = hotelInput.nextLine();

                if (ui.equalsIgnoreCase("-1")) {
                    break;
                } else if (isNum(ui)) {
                    EXECUTIVE_LEVEL_SUITE_ROOMS.add(stringToInt(ui));
                } else {
                    System.out.println("Invalid Room Number!\n");
                    System.out.println("Executive Room Numbers Are currently: " + EXECUTIVE_LEVEL_SUITE_ROOMS);
                }
            } else {
                break;
            }
        }

        while(true){
            System.out.println("Please Set the Price For A Standard Size Room\n(lease exclude the $ symbol):\n>> ");
            String ui = hotelInput.nextLine();
            if(isNum(ui)){
                priceStandardRoom = stringToDouble(ui);
                break;
            }else{
                System.out.println("**Invalid Price**\n");
            }
        }

        while(true){
            System.out.println("Please Set the Price For A Standard Suite Size Room\n(lease exclude the $ symbol):\n>> ");
            String ui = hotelInput.nextLine();
            if(isNum(ui)){
                priceMidRoom = stringToDouble(ui);
                break;
            }else{
                System.out.println("**Invalid Price**\n");
            }
        }

        while(true){
            System.out.println("Please Set the Price For A Luxury Size Room\n(lease exclude the $ symbol):\n>> ");
            String ui = hotelInput.nextLine();
            if(isNum(ui)){
                priceLuxuryRoom = stringToDouble(ui);
                break;
            }else{
                System.out.println("**Invalid Price**\n");
            }
        }

        while(true){
            System.out.println("Please Set the Price For A Executive Size Room\n(lease exclude the $ symbol):\n>> ");
            String ui = hotelInput.nextLine();
            if(isNum(ui)){
                priceExecutiveRoom = stringToDouble(ui);
                break;
            }else{
                System.out.println("**Invalid Price**\n");
            }
        }











    }



}
