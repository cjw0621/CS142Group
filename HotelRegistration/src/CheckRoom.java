import java.util.HashMap;

public class CheckRoom {
    private static final HashMap<Integer, RoomObj> guestRoom = Database.readHotelDBTxt();

    public static int findGuestRoom(String guestName){

        for(int i = 0; i < guestRoom.size(); i++){
            if(guestRoom.get(i).getGuestName().equalsIgnoreCase(guestName)){
                System.out.println(guestRoom.get(i).getRoomNumber());
                return guestRoom.get(i).getRoomNumber();
            }
        }

        System.out.println("***Guest: " + guestName + " was not found!***\n***Check The Name And Try Again!***");
        return -1;
    }


    public static String findGuest(int roomNumber){

        for(int i = 0; i < guestRoom.size(); i++){

            if(guestRoom.get(i).getRoomNumber() == roomNumber){
                System.out.println(guestRoom.get(i).getGuestName());
                return guestRoom.get(i).getGuestName();
            }
        }


        return "Guest Was Not Found!";
    }


    public static int getVacantRoom(boolean hasPets) {
        if (hasPets) {
            for (int i = 0; i < guestRoom.size(); i++) {

                if (guestRoom.get(i).getPetAllowed()) {

                    if (guestRoom.get(i).getGuestName().equalsIgnoreCase("vacant")) {

                        return guestRoom.get(i).getRoomNumber();

                    } else {

                        System.out.println("No Pet Friendly Rooms Are Available!");
                        return -1;
                    }
                }
            }
        } else {

            for (int i = 0; i < guestRoom.size(); i++) {

                if (!guestRoom.get(i).getPetAllowed()) {

                    if (guestRoom.get(i).getGuestName().equalsIgnoreCase("vacant")) {

                        return guestRoom.get(i).getRoomNumber();

                    }
                }
            }
        }
        System.out.println("***No Vacant Rooms Available!***");
        return -1;
    }


    public static void getVacantRoom(){

        System.out.println("\nVacant Rooms: \n");

        for(int i = 0; i < guestRoom.size(); i++){

            if(guestRoom.get(i).getGuestName().equalsIgnoreCase("vacant")){

                System.out.print("Room #: ");
                System.out.print(guestRoom.get(i).getRoomNumber()+"\n");
            }

        }
    }




}
