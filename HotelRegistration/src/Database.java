import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
public class Database {
    final static String EMPLOYEE_DB_FILE = "EmployeeDB.txt";
    final static String MANAGER_DB_FILE ="ManagerDB.txt";
    final static  File employeeDb = new File(EMPLOYEE_DB_FILE);
    final static  File managerDb = new File(MANAGER_DB_FILE);


    public static void writeEmployeeDBtoTxt(){

        BufferedWriter bf = null;

        try{
            if(EmployeeInfo.isManager) {
                if (managerDb.createNewFile()) {
                    bf = new BufferedWriter(new FileWriter(managerDb));

                    for (Map.Entry<String, String> entry : EmployeeInfo.managerDB.entrySet()) {
                        bf.write(entry.getKey() + ":" + entry.getValue());
                        bf.newLine();
                    }

                    System.out.println("File Created Successfully");
                    bf.flush();

                } else if (managerDb.exists()) {

                    String username = EmployeeInfo.getUsername();
                    String password = EmployeeInfo.getPassword();

                    System.out.println("File Already exists");

                    Path path = Paths.get(MANAGER_DB_FILE);

                    Files.write(path, (username + ":" + password).getBytes(), StandardOpenOption.APPEND);
                    Files.write(path, ("\n").getBytes(), StandardOpenOption.APPEND);
                }
            } else {
                if (employeeDb.createNewFile()) {
                    bf = new BufferedWriter(new FileWriter(employeeDb));

                    for (Map.Entry<String, String> entry : EmployeeInfo.employeeDB.entrySet()) {

                        bf.write( entry.getKey() + ":" + entry.getValue());
                        bf.newLine();

                    }
                    System.out.println("File Created Successfully");
                    bf.flush();

                } else if (employeeDb.exists()) {

                    String username = EmployeeInfo.getUsername();
                    String password = EmployeeInfo.getPassword();

                    System.out.println("File Already exists");

                    Path path = Paths.get(EMPLOYEE_DB_FILE);

                    Files.write(path, (username + ":" + password).getBytes(), StandardOpenOption.APPEND);
                    Files.write(path, ("\n").getBytes(), StandardOpenOption.APPEND);
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

                if (eOrM.toLowerCase().equals("e")) {

                    FileReader frEm = new FileReader(employeeDb);

                    BufferedReader brEm = new BufferedReader(frEm);

                    String lineEm;

                    System.out.println("Reading text file use FileReader");

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


                } else if (eOrM.toLowerCase().equals("m")) {
                    FileReader frMa = new FileReader(managerDb);

                    BufferedReader brMa = new BufferedReader(frMa);
                    String lineMa;
                    System.out.println("Reading Text File Using FileReader!");

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
                }

            } catch (IOException e) {

                System.out.println(e + "\n");
                System.out.println("File was not found. Creating a new File...\n");
                SignInClass.signIn();
            }
        }
    }

}
