package util;
import java.io.*;
import java.util.ArrayList;
public class FileUtil {
    public static void writeFile(String fileName, String data){
        try{
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(data+System.lineSeparator());
            fw.close();
        } catch(IOException e){
            System.out.println("Error in writing file");
        }
    }

    public static void readFile(String fileName){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        } catch(IOException e){
            System.out.println("Error in reading the file");
        }
    }
    // data menu mein file se aaye na ki ram se uske liye ye additional method use kr rhi
    public static ArrayList<String> readFileLine(String fileName){
        ArrayList<String> line = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String l;
            while((l = br.readLine()) != null){
                line.add(l);
            }
            br.close();
        } catch(IOException e){

        }
        return line;
    }
}
