package project2;


import java.util.ArrayList;

public class Bound {
    private ArrayList<Point> points= new ArrayList<>();
    public Bound(int x_m,int y_m){
        points.add(new Point(0,0));
        points.add(new Point(x_m,0));
        points.add(new Point(0,y_m));
        points.add(new Point(x_m,y_m));
    }
    public void set_mb(int x_m,int y_m){
        points.set(1,new Point(x_m,0));
        points.set(2,new Point(0,y_m));
        points.set(3,new Point(x_m,y_m));
    }
    public void add_point(int x,int y){
        points.add(new Point(x,y));
    }
}
