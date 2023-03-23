import java.util.*;
public class HotelConfiguration{
    private final static Scanner hotelInput = new Scanner(System.in);
    private static int maxNumOfRooms = 0;
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
    private static double pricePetCleaningFee = 0.0;

    public static RoomObj rooms = new RoomObj("vacant", 0, allRoomsPetFriendly,
            1, 1, "green", priceStandardRoom);
    public static HashMap<Integer, RoomObj> hotelRooms = new HashMap<>(0);

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

    public static int stringToInt(String a){
        //Converts String type number into an Int type number.
        return Integer.parseInt(a);
    }

    public static double stringToDouble(String a){
        //Converts String type number into a Double type number.
        return Double.parseDouble((a));
    }

    public static void config(){





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
        if (isNum(ui)) {
            maxNumOfRooms = stringToInt(ui);
            break;
        } else {
            System.out.println("Invalid Number of Rooms!\n");
        }
        if (ui.equalsIgnoreCase("//")) {

            break;
        }
    }

    while (true) {

        System.out.print("Are Pets Allowed In All Rooms?\n(Type Either Y Or N)\n>> ");
        String ui = hotelInput.nextLine();

        if(ui.equalsIgnoreCase("n") || ui.equalsIgnoreCase("no")){

            while(!allRoomsPetFriendly){

                System.out.print("Please Indicate Which Rooms are Pet Friendly. When finished type '-1' \n>> ");
                ui = hotelInput.nextLine();

                if(isNum(ui)){

                    PET_FRIENDLY_ROOMS.add(stringToInt(ui));

                } else {

                    if(ui.equalsIgnoreCase("-1")){

                        break;

                    }else {

                        System.out.println("Invalid Response!");
                    }
                }
            }



            while(true){

                System.out.print("How Much Is The Pet Cleaning Fee?\n>> ");

                ui = hotelInput.nextLine();

                if(isNum(ui)){

                    pricePetCleaningFee = stringToDouble(ui);

                    break;

                } else{

                    if(ui.equalsIgnoreCase("-1")){

                        break;

                    }else {

                        System.out.println("Invalid Response!");
                    }
                }
            }

            break;

        } else if(ui.equalsIgnoreCase("y") || ui.equalsIgnoreCase("yes")){

            allRoomsPetFriendly = true;

            break;

        } else if(ui.equalsIgnoreCase("//")){

            break;

        } else {
            System.out.println("Invalid response!");
        }
    }

    while(true){

        System.out.print("How Many Standard Size Suites Are Available For Guests?\n>> ");
        String ui = hotelInput.nextLine();

        if(ui.equalsIgnoreCase("//")){

            break;
        }

        if(isNum(ui)){

            levelTwoSuites = stringToInt(ui);
            break;

        }else{

            System.out.println("Invalid Response!");
        }
    }
    while(true){

        System.out.print("How Many Luxury Level Suites Are Available For Guests?\n>> ");
        String ui = hotelInput.nextLine();

        if(ui.equalsIgnoreCase("//")){

            break;
        }else if(isNum(ui)){

            levelThreeSuites = stringToInt(ui);
            break;

        }else{

            System.out.println("Invalid Response!");
        }
    }

    while(true){

        System.out.print("How Many Executive-Level Suites Are Available For Guests?\n>> ");
        String ui = hotelInput.nextLine();

        if(ui.equalsIgnoreCase("//")){


            break;
        }

        if(isNum(ui)){

            levelFourSuites = stringToInt(ui);
            break;

        }else{

            System.out.println("Invalid Response!");
        }
    }

    do{

        System.out.print("Please Indicate Which Rooms Are Standard Suites.\nType '-1' When finished\n>> ");
        String ui = hotelInput.nextLine();

        if(ui.equalsIgnoreCase("-1")){

            break;

        } else if(isNum(ui)){

            STANDARD_SUITE_ROOMS.add(stringToInt(ui));

        } else{

            System.out.println("Invalid Room Number!\n");
            System.out.println("Standard Suite Room Numbers Are currently: " + STANDARD_SUITE_ROOMS);
        }
    }while (STANDARD_SUITE_ROOMS.size() < levelTwoSuites );


    do {

        if (levelTwoSuites != 0) {

            System.out.print("Please Indicate Which Rooms Are Luxury-Level Suites.\nType '-1' When finished\n>> ");
            String ui = hotelInput.nextLine();

            if (ui.equalsIgnoreCase("//")) {
                break;
            }

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
    }while (LUXURY_LEVEL_SUITE_ROOMS.size() < levelThreeSuites);

    do{

        if(levelFourSuites != 0){

            System.out.print("Please Indicate Which Rooms Are Executive-Level Suites.\nType '-1' When finished\n>> ");
            String ui = hotelInput.nextLine();

            if (ui.equalsIgnoreCase("//")) {

                break;
            }

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

    } while(EXECUTIVE_LEVEL_SUITE_ROOMS.size() < levelFourSuites );

    while(true){

        System.out.print("Please Set the Price For A Standard Size Room\n(Please exclude the $ symbol):\n>> ");
        String ui = hotelInput.nextLine();

        if(ui.equalsIgnoreCase("//")){

            break;
        }

        if(isNum(ui)){

            priceStandardRoom = stringToDouble(ui);
            break;

        }else{

            System.out.println("**Invalid Price**\n");
        }
    }

    while(true){

        System.out.print("Please Set the Price For A Standard Suite Size Room\n(Please exclude the $ symbol):\n>> ");
        String ui = hotelInput.nextLine();

        if(ui.equalsIgnoreCase("//")){

            break;
        }

        if(isNum(ui)){

            priceMidRoom = stringToDouble(ui);
            break;

        }else{
            System.out.println("**Invalid Price**\n");
        }
    }

    while(true){

        System.out.print("Please Set the Price For A Luxury Size Room\n(Please exclude the $ symbol):\n>> ");
        String ui = hotelInput.nextLine();

        if(ui.equalsIgnoreCase("//")){

            break;
        }

        if(isNum(ui)){

            priceLuxuryRoom = stringToDouble(ui);
            break;

        }else{

            System.out.println("**Invalid Price**\n");
        }
    }

    while(true) {

        if (EXECUTIVE_LEVEL_SUITE_ROOMS.size() != 0) {

            System.out.print("Please Set the Price For A Executive Size Room\n(Please exclude the $ symbol):\n>> ");
            String ui = hotelInput.nextLine();

            if (ui.equalsIgnoreCase("//")) {

                break;
            }

            if (isNum(ui)) {

                priceExecutiveRoom = stringToDouble(ui);
                break;

            } else {

                System.out.println("**Invalid Price**\n");
            }
        }
    }

    System.out.println("Building Rooms...");
    hotelBuilder();
    System.out.println("Rooms Built Successfully!");


    }


    /*
     * Method with no parameters or return value. Takes in variables with values given by the users input
     * and auto generates room objects that are then saved as values in the hashmap with index as keys
     *
     */





    public static void hotelBuilder(){

        for (int i = 0; i != maxNumOfRooms; i++) {

            hotelRooms.put(i, rooms);
        }

        for(int i = 0; i < hotelRooms.size(); i++){

            hotelRooms.get(i).setRoomNumber(i+1);
            hotelRooms.get(i).setPrice(priceStandardRoom);
            hotelRooms.get(i).setNumberOfBeds(1);
            hotelRooms.get(i).setPetAllowed(allRoomsPetFriendly);
            hotelRooms.get(i).setSuiteLevel(1);
            hotelRooms.get(i).setGuestName("vacant");
            hotelRooms.get(i).setCleanStatus("green");

            hotelRooms.replace(i, hotelRooms.get(i), new RoomObj(hotelRooms.get(i).getGuestName(),
                    hotelRooms.get(i).getRoomNumber(), hotelRooms.get(i).getPetAllowed(),
                    hotelRooms.get(i).getNumberOfBeds(), hotelRooms.get(i).getSuiteLevel(),
                    hotelRooms.get(i).getCleanStatus(),
                    hotelRooms.get(i).getPrice()));
        }

        if (!allRoomsPetFriendly) {
            for (int i = 0; i < maxNumOfRooms; i++) {

                for (int j = 0; j < PET_FRIENDLY_ROOMS.size(); j++) {

                    if (i == PET_FRIENDLY_ROOMS.get(j)) {

                        hotelRooms.get(i).setPrice(priceStandardRoom + pricePetCleaningFee);
                        hotelRooms.get(i).setPetAllowed(true);

                        hotelRooms.replace(i, hotelRooms.get(i), new RoomObj(hotelRooms.get(i).getGuestName(),
                                hotelRooms.get(i).getRoomNumber(), hotelRooms.get(i).getPetAllowed(),
                                hotelRooms.get(i).getNumberOfBeds(), hotelRooms.get(i).getSuiteLevel(),
                                hotelRooms.get(i).getCleanStatus(), hotelRooms.get(i).getPrice()));


                    }
                }
            }
        }


        if(STANDARD_SUITE_ROOMS.size() != 0) {

            for (int i = 0; i < maxNumOfRooms; i++) {

                for (int j = 0; j < STANDARD_SUITE_ROOMS.size(); j++) {

                    if (i == STANDARD_SUITE_ROOMS.get(j)) {

                        hotelRooms.get(i).setPrice(priceMidRoom);
                        hotelRooms.get(i).setSuiteLevel(2);
                        hotelRooms.get(i).setNumberOfBeds(2);

                        if(hotelRooms.get(i).getPetAllowed()){
                            hotelRooms.get(i).setPrice(priceMidRoom + pricePetCleaningFee);
                        }

                        hotelRooms.replace(i, hotelRooms.get(i), new RoomObj(hotelRooms.get(i).getGuestName(),
                                hotelRooms.get(i).getRoomNumber(), hotelRooms.get(i).getPetAllowed(),
                                hotelRooms.get(i).getNumberOfBeds(), hotelRooms.get(i).getSuiteLevel(),
                                hotelRooms.get(i).getCleanStatus(),
                                hotelRooms.get(i).getPrice()));

                    }
                }
            }
        }



        if (LUXURY_LEVEL_SUITE_ROOMS.size() != 0) {

            for (int i = 0; i < maxNumOfRooms; i++) {

                for (int j = 0; j < LUXURY_LEVEL_SUITE_ROOMS.size(); j++) {

                    if (i == LUXURY_LEVEL_SUITE_ROOMS.get(j)) {

                        hotelRooms.get(i).setSuiteLevel(3);
                        hotelRooms.get(i).setNumberOfBeds(3);
                        hotelRooms.get(i).setPrice(priceLuxuryRoom);

                        if(hotelRooms.get(i).getPetAllowed()){

                            hotelRooms.get(i).setPrice(priceLuxuryRoom + pricePetCleaningFee);
                        }


                        hotelRooms.replace(i, hotelRooms.get(i), new RoomObj(hotelRooms.get(i).getGuestName(),
                                hotelRooms.get(i).getRoomNumber(), hotelRooms.get(i).getPetAllowed(),
                                hotelRooms.get(i).getNumberOfBeds(), hotelRooms.get(i).getSuiteLevel(),
                                hotelRooms.get(i).getCleanStatus(), priceLuxuryRoom));
                    }
                }
            }
        }



        if(EXECUTIVE_LEVEL_SUITE_ROOMS.size() != 0){

            for(int i = 0; i < maxNumOfRooms; i++){

                for (int j = 0; j < EXECUTIVE_LEVEL_SUITE_ROOMS.size(); j++) {

                    if (i == EXECUTIVE_LEVEL_SUITE_ROOMS.get(j)) {

                        hotelRooms.get(i).setSuiteLevel(4);
                        hotelRooms.get(i).setNumberOfBeds(4);
                        hotelRooms.get(i).setPrice(priceExecutiveRoom);

                        if(hotelRooms.get(i).getPetAllowed()){

                            hotelRooms.get(i).setPrice(priceExecutiveRoom + pricePetCleaningFee);
                        }

                        hotelRooms.replace(i, hotelRooms.get(i), new RoomObj(hotelRooms.get(i).getGuestName(),
                                hotelRooms.get(i).getRoomNumber(), hotelRooms.get(i).getPetAllowed(),
                                hotelRooms.get(i).getNumberOfBeds(), hotelRooms.get(i).getSuiteLevel(),
                                hotelRooms.get(i).getCleanStatus(), hotelRooms.get(i).getPrice()));
                    }
                }
            }
        }

        Database.writeHotelDBtoTxt(hotelRooms);

    }



}
