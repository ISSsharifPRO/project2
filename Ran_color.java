package project2;

import java.awt.*;
import java.util.Random;

public class Ran_color {

    Random r = new Random();
    public Color rand_color() {
        int red = r.nextInt(256);
        int blue = r.nextInt(256);
        int yellow = r.nextInt(256);
        Color color = new Color(red, blue, yellow);
        return color;
    }
}
