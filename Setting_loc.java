package project2;

import java.io.*;
import java.util.Scanner;

public class Setting_loc implements Serializable {

    private File f = new File("./src/project2/f.text");
    private String file2;

    public void save(String s){
        try {
            FileWriter fileWriter = new FileWriter(f);
            fileWriter.write(s);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String get_address(){
        String s="";
        try {
            Scanner scanner = new Scanner(f);
            s=scanner.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }

    public File getF() {
        return f;
    }
}
