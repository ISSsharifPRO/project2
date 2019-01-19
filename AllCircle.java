package project2;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

public class AllCircle {
    private ArrayList<Circle> circles = new ArrayList();
    private int x_m,y_m;

    public AllCircle(int width, int length) {
        x_m=width;
        y_m=length;
    }
    public String get_speed(int i){
        return circles.get(i).getI()+"  **  "+circles.get(i).getJ();
    }
    public void add_circle(int x, int y, Double i, Double j){
        circles.add(new Circle(x,y,i,j));
    }
    public void add_circle_rand(Double i, Double j){
        Random r = new Random();
        circles.add(new Circle(r.nextInt(x_m-30)+0,r.nextInt(y_m-30)+0,i,j));
    }
    public ArrayList<Circle> get_circle(){
        return circles;
    }
    public void contact(){
        for (Circle c:circles){
            c.nextpoint(x_m-30,y_m-55);
        }
    }
    public ArrayList<Ellipse2D> ell_cir(){
        ArrayList<Ellipse2D> ell_cir = new ArrayList<>();
        for (Circle c:circles){
            ell_cir.add(new Ellipse2D.Double(c.getX(),c.getY(),30,30));
        }
        return ell_cir;
    }

    public void setbound(int width, int length) {
        x_m=width;
        y_m=length;
    }

    public void cir_con(){
        for (Circle c:circles){
            for (Circle d:circles){
                if (!c.equals(d) && (Math.pow(c.getX()-d.getX(),2)+Math.pow(c.getY()-d.getY(),2))<=900) {
                    Double i1=c.getI();
                    Double j1=c.getJ();
                    Double i2=d.getI();
                    Double j2=d.getJ();
                    c.setSpeed(i2,j2);
                    d.setSpeed(i1,j1);
                    c.setX((int) (c.getX()+c.getI()));
                    d.setX((int) (d.getX()+d.getI()));
                    //System.out.println(222);
                }
            }
        }
    }
}
