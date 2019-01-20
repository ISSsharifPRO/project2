package project2;

import java.io.*;

public class Save_Setting {
    Setting_loc location = new Setting_loc();
    Settings settings;
    public Save_Setting(Settings settings){
        this.settings=settings;
    }
public void save() {
    try {
        FileOutputStream f = new FileOutputStream(new File("myObjects.dat"));

        ObjectOutputStream o = new ObjectOutputStream(f);

        // Write objects to file
        o.writeObject(settings);

        o.close();
        f.close();



    } catch (FileNotFoundException e) {
        System.out.println("File not found");
    } catch (IOException e) {
        System.out.println("Error initializing stream");
    }
}

    public Save_Setting() {
    }

    public Settings read(){
        Settings s =null;
    FileInputStream fi = null;
    try {
        fi = new FileInputStream(new File("myObjects.dat"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        Settings pr1 = (Settings) oi.readObject();
        s=pr1;
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
return s;
}
}
