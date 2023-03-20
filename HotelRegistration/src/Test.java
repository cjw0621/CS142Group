import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Test {

    public static void main(String[] args){

        RoomObj roomObj = new RoomObj("vacant",0,true,1,1,"green",39.99);

        HotelConfiguration.rooms = roomObj;

        HotelConfiguration.hotelBuilder();











    }
}
