import java.util.HashMap;

public class GuestCheckInOut {

    private static final HashMap<Integer, RoomObj> guestRoom = Database.readHotelDBTxt();
    public static void guestCheckIn(String guestName, boolean hasPets, int suiteLevel){


        if (CheckRoom.getVacantRoom(hasPets) != -1 &&
                guestRoom.get(CheckRoom.getVacantRoom(hasPets) - 1).getSuiteLevel() == suiteLevel) {

                guestRoom.get(CheckRoom.getVacantRoom(hasPets)).setGuestName(guestName);

        }else{

            System.out.println("Room Is Not Available!");
        }

        Database.writeHotelDBtoTxt(guestRoom);

    }

    public static void checkGuestOut(int roomNumber){
        for(int i = 0; i < guestRoom.size(); i++){
            if(guestRoom.get(i).getRoomNumber() == roomNumber){
                guestRoom.get(i).setGuestName("Vacant");
                break;
            }
        }

        Database.writeHotelDBtoTxt(guestRoom);
    }
}
