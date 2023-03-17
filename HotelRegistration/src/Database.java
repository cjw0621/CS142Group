import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
public class Database {

    final static String EMPLOYEE_DB_FILE = "EmployeeDB.txt";
    final static String MANAGER_DB_FILE ="ManagerDB.txt";

    public static void writeEmployeeDBtoTxt(){
        HashMap<String, String> managerDB = EmployeeInfo.managerDB;
        HashMap<String, String> employeeDB = EmployeeInfo.employeeDB;
        LinkedList<String> employeeManifest = EmployeeInfo.employeeTracker;

        File fileEm = new File(EMPLOYEE_DB_FILE);
        File fileMa = new File(MANAGER_DB_FILE);

        BufferedWriter bf = null;

        try{
             for(int i = 0; i < employeeManifest.size(); i++) {
                 if (!fileMa.exists()) {
                     bf = new BufferedWriter(new FileWriter(fileMa));

                     for (Map.Entry<String, String> entry : managerDB.entrySet()) {

                         bf.write(entry.getKey() + ": " + entry.getValue());
                         bf.newLine();

                     }
                     System.out.println("File Created Successfully");
                     bf.flush();
                 } else {
                     //append to existing file

                 }

                 if (!fileEm.exists()) {
                     bf = new BufferedWriter(new FileWriter(fileEm));

                     for (Map.Entry<String, String> entry : employeeDB.entrySet()) {

                         bf.write(entry.getKey() + ":" + entry.getValue());
                         bf.newLine();

                     }
                     System.out.println("File Created Successfully");
                     bf.flush();
                 } else {
                     //append to existing file


                 }
             }
        }

        catch (IOException e){
            e.printStackTrace();
        }

        finally {

            try {
                assert bf != null;
                bf.close();
            }

            catch (Exception ignored){

            }
        }
    }

    public static void readDBFile() throws IOException{

        File employeeDb = new File(EMPLOYEE_DB_FILE);

       FileReader frEm = new FileReader(employeeDb);


       BufferedReader brEm = new BufferedReader(frEm);

       String lineEm;

       System.out.println("Reading text file use FileReader");

       while((lineEm = brEm.readLine()) != null ){
            System.out.println(lineEm);
       }
        brEm.close();

        frEm.close();
    }



}
