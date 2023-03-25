import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Database
{
    private final static String EMPLOYEE_DB = "EmployeeDB.txt";
    private final static String MANAGER_DB = "ManagerDB.txt";
    private final static String HOTEL_DB = "HotelDB.Txt";
    private final static File EMPLOYEE_DB_FILE = new File(EMPLOYEE_DB);
    private final static File MANAGER_DB_FILE = new File(MANAGER_DB);
    private final static File HOTEL_DB_FILE = new File(HOTEL_DB);

    /*
     * WriteHotelDBtoTxt takes in a HashMap as a parameter, parses it, and copies the values from the HashMap
     * to a .txt file. The .txt file is then used as a database. Method returns nothing. Method also deletes existing
     * data when ever the HotelBuilder method is called and recreates a new database with updated values to prevent
     * duplication.
     */

    public static void writeHotelDBtoTxt(HashMap<Integer, RoomObj> hashMap)
    {
        BufferedWriter bf;

        try
        {
            if(HOTEL_DB_FILE.delete()){
                System.out.println("\nFile Has Been Update\n");
            }

            if(HOTEL_DB_FILE.createNewFile()){

                bf = new BufferedWriter(new FileWriter(HOTEL_DB_FILE));

                for(Map.Entry<Integer, RoomObj> entry : hashMap.entrySet())
                {
                    bf.write(entry.getKey() + ":" + "["+entry.getValue().getGuestName() +"," +
                               entry.getValue().getRoomNumber()+","+entry.getValue().getPetAllowed()+","+
                               entry.getValue().getNumberOfBeds()+","+entry.getValue().getSuiteLevel()+","+
                               entry.getValue().getCleanStatus()+","+entry.getValue().getPrice()+"]");
                    bf.newLine();
                }

                bf.flush();
            }

        }

        catch(IOException e)
        {
            throw new RuntimeException(e);
        }
   }



   public static HashMap<Integer, RoomObj> readHotelDBTxt()
   {

        HashMap<Integer, String> tempRoomHashMap = new HashMap<>();
        HashMap<Integer, RoomObj> roomHashMap = new HashMap<>();

       try
        {
               String lineEm;
               FileReader frEm = new FileReader("HotelDB.txt");
               BufferedReader brEm = new BufferedReader(frEm);

               while((lineEm = brEm.readLine()) != null)
               {

                   String[] parts = lineEm.split(":");
                   String index = parts[0].trim();
                   String roomObj = parts[1].trim();
                   tempRoomHashMap.put(HotelConfiguration.stringToInt(index), roomObj);
               }

           for(int i = 0; i < tempRoomHashMap.size(); i++)
           {
               tempRoomHashMap.put(i,tempRoomHashMap.get(i).replaceAll("\\[","")
                      .replaceAll("\\]", ""));

               String[] strRoom = tempRoomHashMap.get(i).split(",");

               String guestName = strRoom[0];
               int roomNumber = HotelConfiguration.stringToInt(strRoom[1]);
               boolean petAllowed = HotelConfiguration.isBoolean(strRoom[2]);
               int numberOfBeds = HotelConfiguration.stringToInt(strRoom[3]);
               int suiteLevel = HotelConfiguration.stringToInt(strRoom[4]);
               String cleanStatus = strRoom[5];
               double price = HotelConfiguration.stringToDouble(strRoom[6]);

                roomHashMap.put(i, new RoomObj(guestName, roomNumber, petAllowed, numberOfBeds, suiteLevel, cleanStatus,
                                price));
           }
               brEm.close();
               frEm.close();
       }
       catch(IOException ignore)
        {
        }
        return roomHashMap;
    }



   /*
    * Method will create a new file if no file is present. Method also takes data from EmployeeInfo such as usernames,
    * passwords and stores them in a .txt file in a HashMap format.
    * Method creates objects in order to create and write to .txt file.
    * Objects such as BufferedWriter, and FileWriter.
    *
    * Method takes no Parameters and returns nothing.
    *
   */






    public static void writeEmployeeDBtoTxt()
    {

        BufferedWriter bf;

        try
        {

            if(EmployeeInfo.isManager)
            {
                if(MANAGER_DB_FILE.createNewFile())
                {
                    bf = new BufferedWriter(new FileWriter(MANAGER_DB_FILE));

                    for(Map.Entry<String, String> entry : EmployeeInfo.managerDB.entrySet())
                    {
                        bf.write(entry.getKey() + ":" + entry.getValue());
                        bf.newLine();
                    }
                    bf.flush();
                }
                else if(MANAGER_DB_FILE.exists())
                {
                    String username = EmployeeInfo.getUsername();
                    String password = EmployeeInfo.getPassword();

                    if(username != null && password != null)
                    {
                        Path path = Paths.get(MANAGER_DB);
                        Files.write(path, (username + ":" + password).getBytes(), StandardOpenOption.APPEND);
                        Files.write(path, ("\n").getBytes(), StandardOpenOption.APPEND);
                    }
                }
                else
                {
                    System.out.println("uh-oh! Something Really Bad Happened!");
                }
             }
            else
            {
                if(EMPLOYEE_DB_FILE.createNewFile())
                {
                    bf = new BufferedWriter(new FileWriter(EMPLOYEE_DB_FILE));

                    for (Map.Entry<String, String> entry : EmployeeInfo.employeeDB.entrySet())
                    {
                        bf.write( entry.getKey() + ":" + entry.getValue());
                        bf.newLine();
                    }
                    bf.flush();
                 }

                else if(EMPLOYEE_DB_FILE.exists())
                {
                    String username = EmployeeInfo.getUsername();
                    String password = EmployeeInfo.getPassword();

                    if(username != null && password != null)
                    {
                        Path path = Paths.get(EMPLOYEE_DB);
                        Files.write(path, (username + ":" + password).getBytes(), StandardOpenOption.APPEND);
                        Files.write(path, ("\n").getBytes(), StandardOpenOption.APPEND);
                    }
                }
                else
                {
                    System.out.println("uh-oh! Something Happened!");
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /*
    *
    * This method takes a boolean isManager as a parameter in order to execute functions appropriately.
    * Method creates 2 HashMaps and stores data that it retrieves from the EmployeeDB.txt file and ManagerDB.txt file.
    *
    * The files are in the same format as a HashMap in order for easy transfer of data.
    *
    * Method returns HashMap<String, String> with appropriate corresponding data. The last return statement returns an
    * empty HashMap if something fails.
    *
    */


    public static HashMap<String, String> readEmployeeDBFile(boolean isManager){

        HashMap<String, String> employees = new HashMap<>();
        HashMap<String, String> managers = new HashMap<>();


            try {

                if(!isManager){

                    String lineEm;
                    FileReader frEm = new FileReader(EMPLOYEE_DB_FILE);
                    BufferedReader brEm = new BufferedReader(frEm);

                    while((lineEm = brEm.readLine()) != null) {

                        String[] parts = lineEm.split(":");
                        String username = parts[0].trim();
                        String password = parts[1].trim();

                        if(!username.equals("") && !password.equals("")){

                            employees.put(username, password);
                        }

                    }

                    brEm.close();
                    frEm.close();

                    return employees;


                } else if(isManager){

                    FileReader frMa = new FileReader(MANAGER_DB_FILE);
                    BufferedReader brMa = new BufferedReader(frMa);
                    String lineMa;

                    while((lineMa = brMa.readLine()) != null) {

                        String[] parts = lineMa.split(":");
                        String username = parts[0].trim();
                        String password = parts[1].trim();

                        if (!username.equals("") && !password.equals("")) {

                            managers.put(username, password);
                        }

                    }

                    brMa.close();
                    frMa.close();
                    return managers;

                }else {

                    System.out.println("Incorrect parameter\n");
                    System.out.println("Initializing Employee Database\n");
                    readEmployeeDBFile(false);
                    }

                } catch(IOException ignore) {
                }

        return new HashMap<>();
    }
}
