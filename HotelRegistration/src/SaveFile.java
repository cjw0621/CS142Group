import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {
   public static void CreateFile() {
        try {
            File myObj = new File("SaveFile.txt");
            if(myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File Already Exists.");
            }
        } catch (IOException e) {
            System.out.println("An error Occurred.");
            e.printStackTrace();
        }
    }

    public static void WriteToFile(String fileName, SaveObj save){
       try{
           FileWriter myWriter = new FileWriter(fileName);
           myWriter.write(save.toString());
           myWriter.close();
       } catch (IOException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
       }
    }

}
