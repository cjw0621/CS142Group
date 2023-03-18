import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        int count = 0;
        HashMap<String, String> employeeHash = Database.readDBFile("E");

        System.out.println(employeeHash.toString());


    }
}
