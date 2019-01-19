package project2;

import java.awt.*;
import java.util.ArrayList;

public class Settings {
    //save circles
    private ArrayList<String> cir_name = new ArrayList<>();
    private ArrayList<Circle> circles = new ArrayList<>();
    private int speed;
    private Color bg_color;
    private Color circle_color;
    private Boolean is_fill;

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


    public Settings() {
        circles.add(new Circle(-1, -1, 2.0, 5.0));
        circles.add(new Circle(0, 0, 2.0, -3.2));
        circles.add(new Circle(-1, -1, 2.0, -3.2));
        circles.add(new Circle(0, 90, 2.0, -3.2));
        speed=20;
        bg_color=Color.LIGHT_GRAY;
        circle_color=Color.blue;
        is_fill=true;
    }
}
