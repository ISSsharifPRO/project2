package project2;

import java.awt.*;
import java.util.ArrayList;
import java.io.Serializable;

public class Settings implements Serializable{
    private static final long serialVersionUID = 1L;
    //save circles
    public ArrayList<String> cir_name = new ArrayList<>();
    public ArrayList<Circle> circles = new ArrayList<>();
    public int speed;
    public Color bg_color;
    public Color circle_color;
    public Boolean is_fill;
    Setting_loc setting_loc = new Setting_loc();
    public String file=setting_loc.get_address();

    public ArrayList<Circle> getCircles() {
        return circles;
    }

    public int getSpeed() {
        return speed;
    }

    public Color getBg_color() {
        return bg_color;
    }

    public Color getCircle_color() {
        return circle_color;
    }

    public Boolean getIs_fill() {
        return is_fill;
    }

    public void add_circle(String name, Circle circle){
        cir_name.add(name);
        circles.add(circle);
    }
    public String get_info(){
        String s="";
        for (int i=0; i<cir_name.size(); i++){
            s+="name : "+cir_name.get(i)+" , (x,y)=("+circles.get(i).getX()+","+circles.get(i).getY()+") , <i,j>=<"+circles.get(i).getI()+","+circles.get(i).getJ()+")\n";
        }
        return s;
    }
    public String get_nane(int i){
        return cir_name.get(i);
    }
    public Circle get_cir(int i){
        return circles.get(i);
    }
    public Boolean exist(String s){
        boolean b=false;
        for (String ss:cir_name){
            if (ss.equals(s))
                b=true;
        }
        return b;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        setting_loc.save(file);
    }

    public void delete(String s){
        int i;
        for ( i=0; i<cir_name.size(); i++){
            if (s.equals(cir_name.get(i)))
                break;
        }
        cir_name.remove(i);
        circles.remove(i);
    }
    public void change_speed(String s, Double i, Double j){
        int ii;
        for ( ii=0; ii<cir_name.size(); ii++){
            if (s.equals(cir_name.get(ii)))
                break;
        }
        circles.get(ii).setI(i);
        circles.get(ii).setJ(j);
    }
    public void change(String s,int x, int y, Double i, Double j){
        int ii;
        for ( ii=0; ii<cir_name.size(); ii++){
            if (s.equals(cir_name.get(ii)))
                break;
        }
        circles.get(ii).setI(i);
        circles.get(ii).setJ(j);
        circles.get(ii).setX(x);
        circles.get(ii).setY(y);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setBg_color(Color bg_color) {
        this.bg_color = bg_color;
    }

    public void setCircle_color(Color circle_color) {
        this.circle_color = circle_color;
    }

    public void setIs_fill(Boolean is_fill) {
        this.is_fill = is_fill;
    }

    public Settings() {
        Settings s = (new Save_Setting()).read();
        for (Circle c:s.circles){
            this.circles.add(c);
        }
        for (String c:s.cir_name){
            this.cir_name.add(c);
        }
        this.speed=s.getSpeed();
        this.bg_color=s.getBg_color();
        this.circle_color=s.getCircle_color();
        this.is_fill=s.getIs_fill();
    }

}
