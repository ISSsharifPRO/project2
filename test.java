package project2;

import javax.swing.*;
import java.awt.*;

public class test {
    public static void main(String[] args) {

    }


    public static Color get_color(String s){
        Color c=new Color(192,192,192);
        try {
            int[] t = get_num(s);
            c = new Color(t[0], t[1], t[2]);
        }catch (Exception e){}
        return c;
    }
    public static int[] get_num(String s){
        int[] num = new int[3];
        String p="";
        int t=0;
        for (int i=0; i<s.length(); i++){
            try {
                p+=Integer.parseInt(s.charAt(i)+"")+"";
            }catch (Exception e){
                num[t]=Integer.valueOf(p);
                p="";
                t++;
            }
            if (t==2)
                break;
        }
        return num;
    }
}
