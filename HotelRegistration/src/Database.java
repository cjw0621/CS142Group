import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
public class Database {
    final static String EMPLOYEE_DB = "EmployeeDB.txt";
    final static String MANAGER_DB ="ManagerDB.txt";
    final static  File EMPLOYEE_DB_FILE = new File(EMPLOYEE_DB);
    final static  File MANAGER_DB_FILE = new File(MANAGER_DB);


    public static void writeEmployeeDBtoTxt(){

        BufferedWriter bf = null;

        try{
            if(EmployeeInfo.isManager) {
                if (MANAGER_DB_FILE.createNewFile()) {
                    bf = new BufferedWriter(new FileWriter(MANAGER_DB_FILE));

                    for (Map.Entry<String, String> entry : EmployeeInfo.managerDB.entrySet()) {
                        bf.write(entry.getKey() + ":" + entry.getValue());
                        bf.newLine();
                    }
                    bf.flush();

                } else if (MANAGER_DB_FILE.exists()) {

                    String username = EmployeeInfo.getUsername();
                    String password = EmployeeInfo.getPassword();
                    Path path = Paths.get(MANAGER_DB);

                    Files.write(path, (username + ":" + password).getBytes(), StandardOpenOption.APPEND);
                    Files.write(path, ("\n").getBytes(), StandardOpenOption.APPEND);
                } else {
                    System.out.println("uh-oh! Something Really Bad Happened!");
                }
            } else {

                if (EMPLOYEE_DB_FILE.createNewFile()) {
                    bf = new BufferedWriter(new FileWriter(EMPLOYEE_DB_FILE));

                    for (Map.Entry<String, String> entry : EmployeeInfo.employeeDB.entrySet()) {

                        bf.write( entry.getKey() + ":" + entry.getValue());
                        bf.newLine();

                    }
                    bf.flush();

                } else if (EMPLOYEE_DB_FILE.exists()) {

                    String username = EmployeeInfo.getUsername();
                    String password = EmployeeInfo.getPassword();
                    Path path = Paths.get(EMPLOYEE_DB);

                    Files.write(path, (username + ":" + password).getBytes(), StandardOpenOption.APPEND);
                    Files.write(path, ("\n").getBytes(), StandardOpenOption.APPEND);

                }else {
                    System.out.println("uh-oh! Something Really Bad Happened!");
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

    public static HashMap<String, String> readDBFile(String eOrM) {

        HashMap<String, String> employees = new HashMap<>();
        HashMap<String, String> managers = new HashMap<>();

        while(true) {
            try {

                if (eOrM.equalsIgnoreCase("e")) {

                    FileReader frEm = new FileReader(EMPLOYEE_DB_FILE);

                    BufferedReader brEm = new BufferedReader(frEm);

                    String lineEm;

                    while ((lineEm = brEm.readLine()) != null) {
                        String[] parts = lineEm.split(":");

                        String username = parts[0].trim();
                        String password = parts[1].trim();

                        if (!username.equals("") && !password.equals("")) {
                            employees.put(username, password);
                        }

                    }

                    brEm.close();
                    frEm.close();
                    return employees;


                } else if (eOrM.equalsIgnoreCase("m")) {
                    FileReader frMa = new FileReader(MANAGER_DB_FILE);

                    BufferedReader brMa = new BufferedReader(frMa);
                    String lineMa;

                    while ((lineMa = brMa.readLine()) != null) {

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
                }else{
                    System.out.println("Incorrect parameter\n");
                    System.out.println("Initializing Employee Database\n");
                    readDBFile("e");
                }

            } catch (IOException e) {

                System.out.println(e + "\n");
                System.out.println("File was not found. Creating a new File...\n");
                SignInClass.signIn();
            }
        }
    }

}
