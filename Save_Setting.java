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
        FileOutputStream f = new FileOutputStream(new File(location.get_address()));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(settings);
        o.close();
        f.close();
    } catch (FileNotFoundException e) {

    } catch (IOException e) {
    }
}
    public Save_Setting() {
    }

    public Settings read(){
        Settings s =null;
    FileInputStream fi = null;

        File ff;

   ff=new File(location.get_address());
   if (!ff.exists())
       ff = new File("./src/project2/myObjects.dat");
    try {
        fi = new FileInputStream(ff);
        ObjectInputStream oi = new ObjectInputStream(fi);
        Settings pr1 = (Settings) oi.readObject();
        s=pr1;
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
    } catch (ClassNotFoundException e) {
    }
return s;
}
}
