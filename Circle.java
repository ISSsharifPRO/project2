package project2;

public class Circle{
    private int x,y;
    Double i,j;
    public Circle(int x, int y, Double i, Double j){
        this.x=x;
        this.y=y;
        this.i=i;
        this.j=j;
    }
    public void setSpeed(Double i, Double j){
        this.i=i;
        this.j=j;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setI(Double i) {
        this.i = i;
    }

    public void setJ(Double j) {
        this.j = j;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Double getI() {
        return i;
    }

    public Double getJ() {
        return j;
    }

    public void nextpoint(int x_m, int y_m){
        if (x<0 || x>x_m)
            i=-i;
        if (y<0 || y>y_m)
            j=-j;
         x+=i;
         y+=j;
    }
    public boolean equals(Circle circle){
        if (this.x==circle.getX() && this.y==circle.getY())
            return true;
        else return false;
    }
}
