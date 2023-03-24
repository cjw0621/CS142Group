public class Test {

    public static void main(String[] args){

        Database.writeHotelDBtoTxt(Database.readHotelDBTxt());

        for(int i = 0; i < Database.readHotelDBTxt().size(); i++) {

            int roomNum = Database.readHotelDBTxt().get(i).getRoomNumber();
            System.out.println(roomNum);

        }
    }
}
