import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HotelConfiguration {
    private static final Scanner hotelInput;
    private static int maxNumOfRooms;
    private static boolean allRoomsPetFriendly;
    private static final List<Integer> PET_FRIENDLY_ROOMS;
    private static final List<Integer> STANDARD_SUITE_ROOMS;
    private static final List<Integer> LUXURY_LEVEL_SUITE_ROOMS;
    private static final List<Integer> EXECUTIVE_LEVEL_SUITE_ROOMS;
    private static int levelTwoSuites;
    private static int levelThreeSuites;
    private static int levelFourSuites;
    private static double priceStandardRoom;
    private static double priceMidRoom;
    private static double priceLuxuryRoom;
    private static double priceExecutiveRoom;
    private static double pricePetCleaningFee;
    public static RoomObj rooms;
    public static HashMap<Integer, RoomObj> hotelRooms;

        public static boolean isBoolean(String ui){
            return ui.equalsIgnoreCase("true");
        }


        private static boolean isNum (String ui){
            int counter = 0;
            String ltr = "abcdefghijklmnopqrstuvwxyz?><:!@#$%^&*()_+~`,/;'[]|{}-";
            String[] uiArr = ui.split("");
            String[] ltrArr = ltr.split("");
            String[] var5 = ltrArr;
            int var6 = ltrArr.length;

            for (int var7 = 0; var7 < var6; ++var7) {
                String value = var5[var7];
                String[] var9 = uiArr;
                int var10 = uiArr.length;

                for (int var11 = 0; var11 < var10; ++var11) {
                    String s = var9[var11];
                    if (value.equals(s.toLowerCase())) {
                        ++counter;
                    }
                }
            }

            return counter == 0;
        }

        public static int stringToInt (String a){
            return Integer.parseInt(a);
        }

        public static double stringToDouble (String a){
            return Double.parseDouble(a);
        }

        public static void config () {
            System.out.println("*********************************************\n* Welcome to the Hotel Configuration Portal *\n*********************************************\nTo exit type '//'");

            while (SignInClass.successEM && !SignInClass.successMA) {
                System.out.println("*Please Sign-In as a Manager to Continue*\n\n");
                SignInClass.signIn();
            }

            String ui;
            do {
                System.out.print("\nPlease Enter the Number of Rooms Available for Guests:\n>> ");
                ui = hotelInput.nextLine();
                if (isNum(ui)) {
                    maxNumOfRooms = stringToInt(ui);
                    break;
                }

                System.out.println("Invalid Number of Rooms!\n");
            } while (!ui.equalsIgnoreCase("//"));

            label202:
            while (true) {
                System.out.print("Are Pets Allowed In All Rooms?\n(Type Either Y Or N)\n>> ");
                ui = hotelInput.nextLine();
                if (!ui.equalsIgnoreCase("n") && !ui.equalsIgnoreCase("no")) {
                    if (!ui.equalsIgnoreCase("y") && !ui.equalsIgnoreCase("yes")) {
                        if (ui.equalsIgnoreCase("//")) {
                            break;
                        }

                        System.out.println("Invalid response!");
                        continue;
                    }

                    allRoomsPetFriendly = true;
                    break;
                }

                while (!allRoomsPetFriendly) {
                    System.out.print("Please Indicate Which Rooms are Pet Friendly. When finished type '-1' \n>> ");
                    ui = hotelInput.nextLine();
                    if (isNum(ui)) {
                        PET_FRIENDLY_ROOMS.add(stringToInt(ui));
                    } else {
                        if (ui.equalsIgnoreCase("-1")) {
                            break;
                        }

                        System.out.println("Invalid Response!");
                    }
                }

                while (true) {
                    System.out.print("How Much Is The Pet Cleaning Fee?\n>> ");
                    ui = hotelInput.nextLine();
                    if (isNum(ui)) {
                        pricePetCleaningFee = stringToDouble(ui);
                        break label202;
                    }

                    if (ui.equalsIgnoreCase("-1")) {
                        break label202;
                    }

                    System.out.println("Invalid Response!");
                }
            }

            while (true) {
                System.out.print("How Many Standard Size Suites Are Available For Guests?\n>> ");
                ui = hotelInput.nextLine();
                if (ui.equalsIgnoreCase("//")) {
                    break;
                }

                if (isNum(ui)) {
                    levelTwoSuites = stringToInt(ui);
                    break;
                }

                System.out.println("Invalid Response!");
            }

            while (true) {
                System.out.print("How Many Luxury Level Suites Are Available For Guests?\n>> ");
                ui = hotelInput.nextLine();
                if (ui.equalsIgnoreCase("//")) {
                    break;
                }

                if (isNum(ui)) {
                    levelThreeSuites = stringToInt(ui);
                    break;
                }

                System.out.println("Invalid Response!");
            }

            while (true) {
                System.out.print("How Many Executive-Level Suites Are Available For Guests?\n>> ");
                ui = hotelInput.nextLine();
                if (ui.equalsIgnoreCase("//")) {
                    break;
                }

                if (isNum(ui)) {
                    levelFourSuites = stringToInt(ui);
                    break;
                }

                System.out.println("Invalid Response!");
            }

            do {
                System.out.print("Please Indicate Which Rooms Are Standard Suites.\nType '-1' When finished\n>> ");
                ui = hotelInput.nextLine();
                if (ui.equalsIgnoreCase("-1")) {
                    break;
                }

                if (isNum(ui)) {
                    STANDARD_SUITE_ROOMS.add(stringToInt(ui));
                } else {
                    System.out.println("Invalid Room Number!\n");
                    System.out.println("Standard Suite Room Numbers Are currently: " + STANDARD_SUITE_ROOMS);
                }
            } while (STANDARD_SUITE_ROOMS.size() < levelTwoSuites);

            while (levelTwoSuites != 0) {
                System.out.print("Please Indicate Which Rooms Are Luxury-Level Suites.\nType '-1' When finished\n>> ");
                ui = hotelInput.nextLine();
                if (ui.equalsIgnoreCase("//") || ui.equalsIgnoreCase("-1")) {
                    break;
                }

                if (isNum(ui)) {
                    LUXURY_LEVEL_SUITE_ROOMS.add(stringToInt(ui));
                } else {
                    System.out.println("Invalid Room Number!\n");
                    System.out.println("Luxury Room Numbers Are currently: " + LUXURY_LEVEL_SUITE_ROOMS);
                }

                if (LUXURY_LEVEL_SUITE_ROOMS.size() >= levelThreeSuites) {
                    break;
                }
            }

            while (levelFourSuites != 0) {
                System.out.print("Please Indicate Which Rooms Are Executive-Level Suites.\nType '-1' When finished\n>> ");
                ui = hotelInput.nextLine();
                if (ui.equalsIgnoreCase("//") || ui.equalsIgnoreCase("-1")) {
                    break;
                }

                if (isNum(ui)) {
                    EXECUTIVE_LEVEL_SUITE_ROOMS.add(stringToInt(ui));
                } else {
                    System.out.println("Invalid Room Number!\n");
                    System.out.println("Executive Room Numbers Are currently: " + EXECUTIVE_LEVEL_SUITE_ROOMS);
                }

                if (EXECUTIVE_LEVEL_SUITE_ROOMS.size() >= levelFourSuites) {
                    break;
                }
            }

            while (true) {
                System.out.print("Please Set the Price For A Standard Size Room\n(Please exclude the $ symbol):\n>> ");
                ui = hotelInput.nextLine();
                if (ui.equalsIgnoreCase("//")) {
                    break;
                }

                if (isNum(ui)) {
                    priceStandardRoom = stringToDouble(ui);
                    break;
                }

                System.out.println("**Invalid Price**\n");
            }

            while (true) {
                System.out.print("Please Set the Price For A Standard Suite Size Room\n(Please exclude the $ symbol):\n>> ");
                ui = hotelInput.nextLine();
                if (ui.equalsIgnoreCase("//")) {
                    break;
                }

                if (isNum(ui)) {
                    priceMidRoom = stringToDouble(ui);
                    break;
                }

                System.out.println("**Invalid Price**\n");
            }

            while (true) {
                System.out.print("Please Set the Price For A Luxury Size Room\n(Please exclude the $ symbol):\n>> ");
                ui = hotelInput.nextLine();
                if (ui.equalsIgnoreCase("//")) {
                    break;
                }

                if (isNum(ui)) {
                    priceLuxuryRoom = stringToDouble(ui);
                    break;
                }

                System.out.println("**Invalid Price**\n");
            }

            while (true) {

                System.out.print("Please Set the Price For A Executive Size Room\n(Please exclude the $ symbol):\n>> ");
                ui = hotelInput.nextLine();
                if (ui.equalsIgnoreCase("//")) {
                    break;
                }

                if (isNum(ui)) {
                    priceExecutiveRoom = stringToDouble(ui);
                    break;
                }

                System.out.println("**Invalid Price**\n");
            }

            System.out.println("Building Rooms...");
            hotelBuilder();
            System.out.println("Rooms Built Successfully!");
        }

        public static void hotelBuilder () {
            int i;
            for (i = 0; i != maxNumOfRooms; ++i) {
                hotelRooms.put(i, rooms);
            }

            for (i = 0; i < hotelRooms.size(); ++i) {
                ((RoomObj) hotelRooms.get(i)).setRoomNumber(i + 1);
                ((RoomObj) hotelRooms.get(i)).setPrice(priceStandardRoom);
                ((RoomObj) hotelRooms.get(i)).setNumberOfBeds(1);
                ((RoomObj) hotelRooms.get(i)).setPetAllowed(allRoomsPetFriendly);
                ((RoomObj) hotelRooms.get(i)).setSuiteLevel(1);
                ((RoomObj) hotelRooms.get(i)).setGuestName("vacant");
                ((RoomObj) hotelRooms.get(i)).setCleanStatus("green");
                hotelRooms.replace(i, hotelRooms.get(i), new RoomObj(((RoomObj) hotelRooms.get(i)).getGuestName(), ((RoomObj) hotelRooms.get(i)).getRoomNumber(), ((RoomObj) hotelRooms.get(i)).getPetAllowed(), ((RoomObj) hotelRooms.get(i)).getNumberOfBeds(), ((RoomObj) hotelRooms.get(i)).getSuiteLevel(), ((RoomObj) hotelRooms.get(i)).getCleanStatus(), ((RoomObj) hotelRooms.get(i)).getPrice()));
            }

            int j;
            if (!allRoomsPetFriendly) {
                for (i = 0; i < maxNumOfRooms; ++i) {
                    for (j = 0; j < PET_FRIENDLY_ROOMS.size(); ++j) {
                        if (i == (Integer) PET_FRIENDLY_ROOMS.get(j)) {
                            ((RoomObj) hotelRooms.get(i)).setPrice(priceStandardRoom + pricePetCleaningFee);
                            ((RoomObj) hotelRooms.get(i)).setPetAllowed(true);
                            hotelRooms.replace(i, hotelRooms.get(i), new RoomObj(((RoomObj) hotelRooms.get(i)).getGuestName(), ((RoomObj) hotelRooms.get(i)).getRoomNumber(), ((RoomObj) hotelRooms.get(i)).getPetAllowed(), ((RoomObj) hotelRooms.get(i)).getNumberOfBeds(), ((RoomObj) hotelRooms.get(i)).getSuiteLevel(), ((RoomObj) hotelRooms.get(i)).getCleanStatus(), ((RoomObj) hotelRooms.get(i)).getPrice()));
                        }
                    }
                }
            }

            if (STANDARD_SUITE_ROOMS.size() != 0) {
                for (i = 0; i < maxNumOfRooms; ++i) {
                    for (j = 0; j < STANDARD_SUITE_ROOMS.size(); ++j) {
                        if (i == (Integer) STANDARD_SUITE_ROOMS.get(j)) {
                            ((RoomObj) hotelRooms.get(i)).setPrice(priceMidRoom);
                            ((RoomObj) hotelRooms.get(i)).setSuiteLevel(2);
                            ((RoomObj) hotelRooms.get(i)).setNumberOfBeds(2);
                            if (((RoomObj) hotelRooms.get(i)).getPetAllowed()) {
                                ((RoomObj) hotelRooms.get(i)).setPrice(priceMidRoom + pricePetCleaningFee);
                            }

                            hotelRooms.replace(i, hotelRooms.get(i), new RoomObj(((RoomObj) hotelRooms.get(i)).getGuestName(), ((RoomObj) hotelRooms.get(i)).getRoomNumber(), ((RoomObj) hotelRooms.get(i)).getPetAllowed(), ((RoomObj) hotelRooms.get(i)).getNumberOfBeds(), ((RoomObj) hotelRooms.get(i)).getSuiteLevel(), ((RoomObj) hotelRooms.get(i)).getCleanStatus(), ((RoomObj) hotelRooms.get(i)).getPrice()));
                        }
                    }
                }
            }

            if (LUXURY_LEVEL_SUITE_ROOMS.size() != 0) {
                for (i = 0; i < maxNumOfRooms; ++i) {
                    for (j = 0; j < LUXURY_LEVEL_SUITE_ROOMS.size(); ++j) {
                        if (i == (Integer) LUXURY_LEVEL_SUITE_ROOMS.get(j)) {
                            ((RoomObj) hotelRooms.get(i)).setSuiteLevel(3);
                            ((RoomObj) hotelRooms.get(i)).setNumberOfBeds(3);
                            ((RoomObj) hotelRooms.get(i)).setPrice(priceLuxuryRoom);
                            if (((RoomObj) hotelRooms.get(i)).getPetAllowed()) {
                                ((RoomObj) hotelRooms.get(i)).setPrice(priceLuxuryRoom + pricePetCleaningFee);
                            }

                            hotelRooms.replace(i, hotelRooms.get(i), new RoomObj(((RoomObj) hotelRooms.get(i)).getGuestName(), ((RoomObj) hotelRooms.get(i)).getRoomNumber(), ((RoomObj) hotelRooms.get(i)).getPetAllowed(), ((RoomObj) hotelRooms.get(i)).getNumberOfBeds(), ((RoomObj) hotelRooms.get(i)).getSuiteLevel(), ((RoomObj) hotelRooms.get(i)).getCleanStatus(), priceLuxuryRoom));
                        }
                    }
                }
            }

            if (EXECUTIVE_LEVEL_SUITE_ROOMS.size() != 0) {
                for (i = 0; i < maxNumOfRooms; ++i) {
                    for (j = 0; j < EXECUTIVE_LEVEL_SUITE_ROOMS.size(); ++j) {
                        if (i == (Integer) EXECUTIVE_LEVEL_SUITE_ROOMS.get(j)) {
                            ((RoomObj) hotelRooms.get(i)).setSuiteLevel(4);
                            ((RoomObj) hotelRooms.get(i)).setNumberOfBeds(4);
                            ((RoomObj) hotelRooms.get(i)).setPrice(priceExecutiveRoom);
                            if (((RoomObj) hotelRooms.get(i)).getPetAllowed()) {
                                ((RoomObj) hotelRooms.get(i)).setPrice(priceExecutiveRoom + pricePetCleaningFee);
                            }

                            hotelRooms.replace(i, hotelRooms.get(i), new RoomObj(((RoomObj) hotelRooms.get(i)).getGuestName(), ((RoomObj) hotelRooms.get(i)).getRoomNumber(), ((RoomObj) hotelRooms.get(i)).getPetAllowed(), ((RoomObj) hotelRooms.get(i)).getNumberOfBeds(), ((RoomObj) hotelRooms.get(i)).getSuiteLevel(), ((RoomObj) hotelRooms.get(i)).getCleanStatus(), ((RoomObj) hotelRooms.get(i)).getPrice()));
                        }
                    }
                }
            }

            Database.writeHotelDBtoTxt(hotelRooms);
        }

        static {
            hotelInput = new Scanner(System.in);
            maxNumOfRooms = 0;
            allRoomsPetFriendly = false;
            PET_FRIENDLY_ROOMS = new ArrayList<>(0);
            STANDARD_SUITE_ROOMS = new ArrayList<>(0);
            LUXURY_LEVEL_SUITE_ROOMS = new ArrayList<>(0);
            EXECUTIVE_LEVEL_SUITE_ROOMS = new ArrayList<>(0);
            levelTwoSuites = 0;
            levelThreeSuites = 0;
            levelFourSuites = 0;
            priceStandardRoom = 0.0;
            priceMidRoom = 0.0;
            priceLuxuryRoom = 0.0;
            priceExecutiveRoom = 0.0;
            pricePetCleaningFee = 0.0;
            rooms = new RoomObj("vacant", 0, allRoomsPetFriendly, 1, 1, "green", priceStandardRoom);
            hotelRooms = new HashMap<>(0);
        }



}
