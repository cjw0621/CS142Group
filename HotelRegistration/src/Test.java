import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Test {

    public static void main(String[] args){

        Database.writeHotelDBtoTxt(Database.readHotelDBTxt());


    for(int i = 0; i < Database.readHotelDBTxt().size(); i++) {
        int roomNum = Database.readHotelDBTxt().get(i).getRoomNumber();
        System.out.println(roomNum);
    }








    }
}
