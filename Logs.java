package project2;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.*;

public class Logs implements Serializable {
    List<String> strings2 = new ArrayList<>();
    {
        strings2.add("</>");
    }
    public long l  = System.currentTimeMillis();
    long yy=0;
    public long y;
    public long x=0;
    public void add_contact(String s){
        if (strings2.size()==1) {
            strings2.add(s + (System.currentTimeMillis() - l+x) + "(ms)");
        }else if (!s.equals(strings2.get(strings2.size()-1)) && !s.equals(strings2.get(strings2.size()-2))){
            y = System.currentTimeMillis()-l;
            if (y-yy>500)
            strings2.add(s+(y+x)+"(ms)");
            yy=y;
        }
    }
    public String[] get_log() {
        String[] re = new String[strings2.size()];
        int i = 0;
        for (String s : strings2) {
            re[i] = s;
            i++;
        }
        return re;
    }
}
